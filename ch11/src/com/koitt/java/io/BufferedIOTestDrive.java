package com.koitt.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTestDrive {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("music.mp3");
			fos = new FileOutputStream("music_copy.mp3");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			long startTime = System.currentTimeMillis();
			System.out.println("�������");
			
			byte[] buffer = new byte[100];
			
			while(bis.read(buffer) != -1) {
				bos.write(buffer);
			}
			
			System.out.println(System.currentTimeMillis() - startTime);
			System.out.println("��������");
			
			bos.close();
			bis.close();
			fos.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
