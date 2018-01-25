package com.koitt.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTestDrive{
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", "서울", 30);
		Person p2 = new Person("홍길순", "부산", 28);
		Person p3 = new Person("홍길자", "전주", 35);
		
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("person.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);
//			oos.writeObject(null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		System.out.println("저장완료.");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("person.txt");
			ois = new ObjectInputStream(fis);
			
			Object item = null;
			while((item = ois.readObject()) != null) {
				System.out.print("이름 : ");
				System.out.println(((Person)item).getName());
				System.out.print("나이 : ");
				System.out.println(((Person)item).getAge());
				System.out.print("주소 : ");
				System.out.println(((Person)item).getAddress());
				
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
