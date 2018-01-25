package com.koitt.java.board.exception;

// 1. 클래스 생성 후 Exception 상속받기
public class BoardException extends Exception {
	
	public BoardException(String msg) {
		super(msg);
	}
}
