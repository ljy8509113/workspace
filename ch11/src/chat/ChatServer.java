package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	int port = 7070;
	ServerSocket server;
	Socket socket;
	
	public ChatServer(int port) {
		this.port = port;
		System.out.println(">>서버를 시작합니다.");
		try {
			server = new ServerSocket(this.port);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void communicate() {
		System.out.println(">> 클라이언트가 접속하길 기다리고 있습니다.");
		try {
			socket = server.accept();
			printInfo();
			MsgSender sender = new MsgSender("서버", socket);
			MsgReceiver receiver = new MsgReceiver("서버",socket);
			
			receiver.start();
			sender.start();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		try {
			socket.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printInfo() {
		System.out.println(">>클라이언트가 접속에 성공했습니다.");
		System.out.println("		서버 포트 번호: " + socket.getLocalPort());
		System.out.println("		클라이언트 주소: " +socket.getInetAddress());
		System.out.println("		클라이언트 포트번호: "+socket.getPort()+"\n");
		System.out.println(">> 클라이언트에 전달할 메시지를 쓰고 Enter를 누르세요."+"\n");
		
	}
	
	public static void main(String[] args) {
		int port = 7070;
		ChatServer myServer = new ChatServer(port);
		myServer.communicate();
	}
	
}
