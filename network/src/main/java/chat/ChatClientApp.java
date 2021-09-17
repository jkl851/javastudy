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
	private static final int SERVER_PORT = 8000;
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		try {
		//있어야 할것 네임, 소켓, 공유할 리스트, 리스트 synchronized(list), list.add(pw), base64인코딩&디코딩(스페이스없애기)
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		socket = new Socket();
		
		socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		String join = "join:";
		pw.println(join+name + "님이 방에 입장하셨습니다.");
		new ChatClientThread(socket, listWriters).start();
		
		while(true) {
			System.out.print(">");
			String line = scanner.nextLine();
			
			if("exit".equals(line)) {
				pw.println("exit:" + name);
				break;
			}
			
			pw.println("message:" + line);
			
//			String data = br.readLine();
			}
		} catch(SocketException e) {
			log("suddenly closed by server");
		} catch(IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//new ChatWindow(name).show();
	}
	
	private static void log(String log) {
		System.out.println("[Client] " + log);
	}
}
