package com.koitt.java.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BasicUDPServer {
	DatagramSocket dsock;
	DatagramPacket sPack, rPack;
	InetAddress client;
	int sport = 7777, cport;

	public BasicUDPServer(int sport) {
		try {
			this.sport = sport;
			System.out.println("������ �����մϴ�.");
			System.out.println("Ŭ�� ���� �����");
			this.dsock = new DatagramSocket();

		}catch(SocketException e) {
			e.printStackTrace();
		}
	}

	public void communicate() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				byte[] buffer = new byte[1024];
				this.rPack = new DatagramPacket(buffer, buffer.length);
				this.dsock.receive(rPack);
				String strIn = new String(rPack.getData(), 0, rPack.getData().length);
				client = rPack.getAddress();
				cport = rPack.getPort();
				System.out.println("Ŭ�� : "+client+" : " + cport + " > "+strIn);

				if(strIn.trim().equals("quit"))
					break;
				String strOut = br.readLine();
				sPack = new DatagramPacket(strOut.getBytes(), strOut.getBytes().length, client, cport);
				dsock.send(sPack);
					
			}
			System.out.println("���� ����");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BasicUDPServer client = new BasicUDPServer(7777);
		client.communicate();
	}
}
