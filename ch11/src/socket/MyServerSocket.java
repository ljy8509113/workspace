package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	int port = 7070;
	ServerSocket server;
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public MyServerSocket(int port) {
		this.port = port;
		System.out.println(">>������ �����մϴ�.");
		try {
			server = new ServerSocket(this.port);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void waitForClient() {
		System.out.println(">> Ŭ���̾�Ʈ�� �����ϱ� ��ٸ��� �ֽ��ϴ�.");
		try {
			socket = server.accept();
			printInfo();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void receive() {
		try {
			System.out.println("[Ŭ���̾�Ʈ]"+in.readLine());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void send(String msg) {
		out.println(msg);
		out.flush();
		System.out.println("���� : "+msg);
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
		
	}
	
	public static void main(String[] args) {
		int port = 7070;
		MyServerSocket myServer = new MyServerSocket(port);
		myServer.waitForClient();
		myServer.receive();
		myServer.send("������ �����Ͻ� ���� Ȯ���մϴ�.");
		myServer.close();
	}
	
}
