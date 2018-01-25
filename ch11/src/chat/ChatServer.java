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
		System.out.println(">>������ �����մϴ�.");
		try {
			server = new ServerSocket(this.port);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void communicate() {
		System.out.println(">> Ŭ���̾�Ʈ�� �����ϱ� ��ٸ��� �ֽ��ϴ�.");
		try {
			socket = server.accept();
			printInfo();
			MsgSender sender = new MsgSender("����", socket);
			MsgReceiver receiver = new MsgReceiver("����",socket);
			
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
		System.out.println(">>Ŭ���̾�Ʈ�� ���ӿ� �����߽��ϴ�.");
		System.out.println("		���� ��Ʈ ��ȣ: " + socket.getLocalPort());
		System.out.println("		Ŭ���̾�Ʈ �ּ�: " +socket.getInetAddress());
		System.out.println("		Ŭ���̾�Ʈ ��Ʈ��ȣ: "+socket.getPort()+"\n");
		System.out.println(">> Ŭ���̾�Ʈ�� ������ �޽����� ���� Enter�� ��������."+"\n");
		
	}
	
	public static void main(String[] args) {
		int port = 7070;
		ChatServer myServer = new ChatServer(port);
		myServer.communicate();
	}
	
}
