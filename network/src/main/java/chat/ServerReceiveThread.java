package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ServerReceiveThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;

	public ServerReceiveThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		Server.log("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
		BufferedReader br;
		PrintWriter pw;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			// PrintWriter(); ture 옵션 - flush 자동,false시 직접 튜닝
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String request = br.readLine();
				if (request == null) {
					Server.log("클라이언트로 부터 연결 끊김");
					break;
				}
				// “message:하이 ^^;\r\n” - 프로토콜
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {

					doJoin(tokens[1], pw);

				} else if ("message".equals(tokens[0])) {

					doMessage(tokens[1]);

				} else if ("exit".equals(tokens[0])) {
					// Server.log();
					doExit(tokens[1], pw);

				} else {

					Server.log("에러: 알수 없는 요청(" + tokens[0] + ")");
				}

				Server.log("received:" + request);

			}
		} catch (IOException e) {
			Server.log("error:" + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doJoin(String Nickname, PrintWriter pw) throws IOException {
		this.nickname = Nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(pw);

		// ack : acknowledge character
		pw.println("join:ok");
		//pw.flush();
	}

	private void broadcast(String data) {

		synchronized (listWriters) {

			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}

		}

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}

	}

	private void doMessage(String string) {
		broadcast(nickname + ":" + string);
	}

	private void doExit(String name, Writer writer) {
		String data = name + "님이 퇴장 하였습니다.";
		broadcast(data);
		removeWriter(writer);

	}

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}

}
