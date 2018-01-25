package com.koitt.sql;

import java.util.function.Function;

public class Enum {
	public enum City { Seoul, Busan, Daegu, Gwangju, Daejun }
	public enum IntegerValue {
		A, 
		B, 
		C, 
		D;
		
		}

	
	public static void main(String[] args) {
		System.out.println(City.Seoul);
		System.out.println(City.Busan);
	}
}
