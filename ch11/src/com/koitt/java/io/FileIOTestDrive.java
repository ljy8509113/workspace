package com.koitt.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTestDrive {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("music.mp3");
			fos = new FileOutputStream("music_copy.mp3");
			
			long startTime = System.currentTimeMillis();
			System.out.println("복사시작");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			System.out.println(System.currentTimeMillis() - startTime);
			System.out.println("복사종료");
			
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
