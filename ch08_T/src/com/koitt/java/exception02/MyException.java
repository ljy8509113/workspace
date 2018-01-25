package com.koitt.java.exception02;

public class MyException extends Exception {
	
	public MyException(String msg) {
		super(msg);	// getMessage() 호출 시 출력되는 메시지
	}
}
