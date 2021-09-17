package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static final int PORT = 8000;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:" + PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ServerReceiveThread(socket, listWriters).start();
			}
			
		} catch(IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[Server] " + log);
	}
}
