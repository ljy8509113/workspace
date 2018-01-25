package com.koitt.java.exception;

public class CallForName {
	
	public void call() throws ClassNotFoundException {
		Class<?> forName = Class.forName("java.lang.Objec");
		System.out.println(forName);
	}
}
