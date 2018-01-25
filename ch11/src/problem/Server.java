package problem;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import chat.MsgReceiver;
import chat.MsgSender;

public class Server {
	ServerSocket serverSocket;
	int port = 8888;
	Socket socket;
	
	public Server(int port) {
		this.port = port;
		try {
			serverSocket = new ServerSocket(this.port);
			System.out.println("서버 실행중.");
			while(true) {
				socket = serverSocket.accept();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void close() {
		try {
			socket.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
