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
		System.out.println(">>서버를 시작합니다.");
		try {
			server = new ServerSocket(this.port);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void waitForClient() {
		System.out.println(">> 클라이언트가 접속하길 기다리고 있습니다.");
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
			System.out.println("[클라이언트]"+in.readLine());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void send(String msg) {
		out.println(msg);
		out.flush();
		System.out.println("서버 : "+msg);
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
		
	}
	
	public static void main(String[] args) {
		int port = 7070;
		MyServerSocket myServer = new MyServerSocket(port);
		myServer.waitForClient();
		myServer.receive();
		myServer.send("서버에 접속하신 것을 확영합니다.");
		myServer.close();
	}
	
}
