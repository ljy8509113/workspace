package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgSender extends Thread {
	String nickname;
	Socket socket;
	PrintWriter out;
	
	public MsgSender(String naicname, Socket socket) {
		this.nickname = "["+nickname+"]";
		this.socket = socket;
		
		try {
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(IOException e) {
			System.out.println(e.toString());
		}		
	}
	
	@Override
	public void run() {
		Scanner s = new Scanner(System.in);
		while(out != null) {
			String msg = s.nextLine();
			out.println(nickname + msg);
			out.flush();
		}
	}
	
	
}
