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
		MsgSender sender = new MsgSender("Ŭ���̾�Ʈ", socket);
		MsgReceiver receiver = new MsgReceiver("Ŭ���̾�Ʈ", socket);
		
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
		System.out.println(">>���� ���ӿ� �����߽��ϴ�.");
		System.out.println("		���� �ּ�: " + socket.getInetAddress());
		System.out.println("		���� ��Ʈ��ȣ: " +socket.getPort());
		System.out.println("		Ŭ���̾�Ʈ ��Ʈ��ȣ: "+socket.getLocalPort()+"\n");
		System.out.println(">> ������ ������ �޽����� ���� Enter�� ��������."+"\n");
	}
	
	public static void main(String[] args) {
		int port = 7070;
		ChatClient client = new ChatClient("127.0.0.1", port);
		
		System.out.print("�������� ���� �޽��� �Է� >> ");
		client.communicate();
		
	}
	
}
