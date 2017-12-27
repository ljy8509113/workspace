package problem;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("섭씨(c), 화씨(F) 중 한가지와 온도(실수)를 입력 : ");
		String a = in.next();
		double c = in.nextDouble();
		
		if(a.toLowerCase().equals("c")) {
			System.out.printf("C : %f %n", (9.0/5.0)*c + 32 );
		}else if(a.toLowerCase().equals("f")) {
			System.out.printf("F : %f %n", (5.0/9.0)*(c - 32) );
		}else {
			System.out.println("입력오류" );
		}	
		
	}
}
