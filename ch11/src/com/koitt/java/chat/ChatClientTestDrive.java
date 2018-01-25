package com.koitt.java.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClientTestDrive {
	private Socket socket;				//서버 전송 소켓
	private ObjectOutputStream oos;	//서버로 전송 위한 스트림
	private ObjectInputStream ois;	//서버로 부터 받은 스트림
	String name;
	
	class ChatClientThread extends Thread{
		
		@Override
		public void run() {
			while(true) {
				try {
					Object obj = ois.readObject();
					
					if(obj instanceof String) {
						String serverMsg = (String)obj;
						System.out.println(serverMsg);
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class SendThread extends Thread{
		Scanner in;
		
		public SendThread() {
			// TODO Auto-generated constructor stub
			in = new Scanner(System.in);
		}
		
		@Override
		public void run() {
			while(true) {
				String msg = "[" + name + "]" + in.nextLine();
				try {
					oos.writeObject(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void go(String ip, int port, String name) throws UnknownHostException, IOException {
		this.name = name;
		socket = new Socket(ip, port);
		System.out.println("서버 접속 성공 ");
		
		OutputStream out  = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		
		oos = new ObjectOutputStream(out);
		ois = new ObjectInputStream(in);
		
		new ChatClientThread().start();
		new SendThread().start();
	}
	
	public static void main(String[] args) {
		try {
			String name = InetAddress.getLocalHost().getHostAddress();
//			new ChatClientTestDrive().go("192.168.0.11", 7070, name);
			new ChatClientTestDrive().go("127.0.0.1", 7070, name);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("아이피 주소 틀림.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
