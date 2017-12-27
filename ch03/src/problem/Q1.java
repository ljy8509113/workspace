package problem;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("두 실수 입력 : ");
		double a = in.nextDouble();
		double b = in.nextDouble();
		
		System.out.printf("평균 %f", (a+b)/2 );
		
	}
}
