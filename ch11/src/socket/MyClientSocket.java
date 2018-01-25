package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public MyClientSocket(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			printInfo();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void receive() {
		try {
			System.out.println("[����]"+in.readLine());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void send(String msg) {
		out.println(msg);
		out.flush();
		System.out.println("Ŭ���̾�Ʈ : "+msg);
	}
	
	public void close() {
		try {
			socket.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printInfo() {
		System.out.println(">>���� ���ӿ� �����߽��ϴ�.");
		System.out.println("		���� �ּ�: " + socket.getInetAddress());
		System.out.println("		���� ��Ʈ��ȣ: " +socket.getPort());
		System.out.println("		Ŭ���̾�Ʈ ��Ʈ��ȣ: "+socket.getLocalPort()+"\n");
		
	}
	
	public static void main(String[] args) {
		int port = 7070;
		MyClientSocket client = new MyClientSocket("127.0.0.1", port);
		
		System.out.print("�������� ���� �޽��� �Է� >> ");
		Scanner in = new Scanner(System.in);
		String msg = in.nextLine();
		client.send(msg);
		client.receive();
		client.close();
		
	}
	
}
