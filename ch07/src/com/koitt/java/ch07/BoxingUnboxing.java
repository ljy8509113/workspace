package com.koitt.java.ch07;

public class BoxingUnboxing {
	
	public static void main(String[] args) {
		Double radius = 2.59;
		double r = radius;
		
		System.out.print("반지름 : "+ r + ", 원 면적: ");
		System.out.println(radius*radius*Math.PI);

		Integer x = 5, y = 3;
		System.out.printf("%d + %d = %d %n", x, y, x+y);
		Boolean b = true;
		System.out.printf("%b \n", b);
		
	}
}
