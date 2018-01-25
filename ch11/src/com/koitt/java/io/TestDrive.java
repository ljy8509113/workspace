package com.koitt.java.io;

import java.io.IOException;
import java.util.Date;

class TestRunnable implements Runnable{
	public TestRunnable() {
		
	}
	int c = 0;
	@Override
	public void run() {
		c++;
		while(true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
				String s = System.console().readLine();
				System.console().printf("%d", 5);
				
//				String penguinClearConsole = "Clear";
//				String windowsClearConsole = "cls";
//				 
//				String os = System.getProperty("os.name");
//				
//				try {
//					if(os.startsWith("Windows")){
//							Runtime.getRuntime().exec(penguinClearConsole);
//					}
//					else if(os.startsWith("Linux")){
//						Runtime.getRuntime().exec(windowsClearConsole);
//					}
//				} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//				}
			}catch(Exception e) {
				break;
			}
		}
	}
}

public class TestDrive {
	
	public static void main(String[] args) {
		Runnable t = new TestRunnable();
//		Person p = new Person();
		new Thread(t).start();
		
		System.out.println("----");
	}
	
	
}
