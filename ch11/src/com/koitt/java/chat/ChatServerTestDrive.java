package com.koitt.java.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class User{
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public User(Socket s, ObjectInputStream ois, ObjectOutputStream oos) {
		this.socket = s;
		this.ois = ois;
		this.oos = oos;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
	public void close() throws IOException{
		ois.close();
		oos.close();
		socket.close();
	}
	
}



public class ChatServerTestDrive {
	public static final int PORT = 7070;
	private List<User> userList;
	
	public ChatServerTestDrive() {
		userList = new ArrayList<User>();
	}
	
	class ChatServerThread extends Thread{
		ObjectInputStream ois;
		
		public ChatServerThread(ObjectInputStream ois) {		
			this.ois = ois;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Object obj = ois.readObject();
					if(obj instanceof String) {
						String msg = (String )obj;
						broadcast(msg);
						System.out.println(msg);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					removeClient(ois);
				}
			}
		}

		private void broadcast(String msg) {
			// TODO Auto-generated method stub
			for(int i=0; i<userList.size(); i++) {
				try {
					userList.get(i).getOos().writeObject(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		
		public void removeClient(ObjectInputStream ois) {
			for(User user : userList) {
				ObjectInputStream in = user.getOis();
				if(in.equals(ois)) {
					try {
						user.getOis().close();
						user.getOos().close();
						user.getSocket().close ();
						
						userList.remove(user);
						broadcast("사용자 out");
						System.out.println("사용자가 나감.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	public void go() {
		try {
		ServerSocket serverSocket = new ServerSocket(PORT);
		while(true) {
			System.out.println("클라이언트 접속 대기중...");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 접속");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			ObjectInputStream ois = new ObjectInputStream(in);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			
			User user = new User(socket, ois, oos);
			userList.add(user);
			System.out.println("사용자 추가 완료. ");
			
			new ChatServerThread(ois).start();
			
		}
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new ChatServerTestDrive().go();
	}
}
