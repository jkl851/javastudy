package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		try {
			// 있어야 할것 네임, 소켓, 공유할 리스트, 리스트 synchronized(list), list.add(pw),
			// base64인코딩&디코딩(스페이스없애기)
			while (true) {

				System.out.println("대화명을 입력하세요.");
				System.out.print(">> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false) {
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
	

			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			pw.println("join:" + name);
			pw.flush();
			new ChatClientThread(socket, br).start();
			
			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if ("exit".equals(line)) {
					pw.println("exit:" + name);
					break;
				}
				
				pw.println("message:" + line);
				

				
			}
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[Client] " + log);
	}

}

class ChatClientThread extends Thread {
	Socket socket = null;
	BufferedReader br = null;
	
	public ChatClientThread(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while(true) {
				String line = br.readLine();
				System.out.println(line);
			}
			
			} catch(IOException e) {
				System.out.println("error: " + e);
			} finally {
				try {
					socket.close();
					br.close();
				} catch (IOException e) {
					System.out.println("error: " + e);
				}	
			}
	}
}