package com.koitt.java.exception;

public class TestDrive {

	public static void main(String[] args) {
		CallForName object = new CallForName();
		try {
			object.call();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("예외가 정상적으로 처리됐다면 출력되겠지");
	}
}
