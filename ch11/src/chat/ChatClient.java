package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public ChatClient(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			printInfo();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void communicate() {
		MsgSender sender = new MsgSender("클라이언트", socket);
		MsgReceiver receiver = new MsgReceiver("클라이언트", socket);
		
		sender.start();
		receiver.start();
	}
	
	public void close() {
		try {
			socket.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printInfo() {
		System.out.println(">>서버 접속에 성공했습니다.");
		System.out.println("		서버 주소: " + socket.getInetAddress());
		System.out.println("		서버 포트번호: " +socket.getPort());
		System.out.println("		클라이언트 포트번호: "+socket.getLocalPort()+"\n");
		System.out.println(">> 서버에 전달할 메시지를 쓰고 Enter를 누르세요."+"\n");
	}
	
	public static void main(String[] args) {
		int port = 7070;
		ChatClient client = new ChatClient("127.0.0.1", port);
		
		System.out.print("서버에게 보낼 메시지 입력 >> ");
		client.communicate();
		
	}
	
}
