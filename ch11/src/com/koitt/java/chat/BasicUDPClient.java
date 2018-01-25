package com.koitt.java.chat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BasicUDPClient {
	DatagramSocket dsock;
	DatagramPacket sPack, rPack;
	InetAddress server;
	int port = 8888;

	public BasicUDPClient(String ip, int port) {
		try {
			server = InetAddress.getByName(ip);
			this.port = port;
			this.dsock = new DatagramSocket();

			System.out.println(">> 서버에 접속합니다.");
			System.out.println("메시지 + enter");
			System.out.println("종료 : quit");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void communicate() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String strOut = null;
			while((strOut = br.readLine()) != null) {
				this.sPack = new DatagramPacket(strOut.getBytes(), strOut.getBytes().length, server, port);
				this.dsock.send(sPack);
				if(strOut.trim().equals("quit"))
					break;
				
				byte[] buffer = new byte[1024];
				rPack = new DatagramPacket(buffer, buffer.length);
				dsock.receive(rPack);
				String strIn = new String(rPack.getData(), 0, rPack.getData().length);
				System.out.println("서버 [" + server+" : "+port+"] "+strIn);
									
			}
			System.out.println("클라 종료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BasicUDPClient client = new BasicUDPClient("127.0.0.1",7777);
		client.communicate();
	}
}
