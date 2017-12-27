package problem;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("두 실수 입력 : ");
		double a = in.nextDouble();
		double b = in.nextDouble();
		
		int c = (int)a;
		int d = (int)b;
		
		System.out.printf("합 : %f , 평균 %f", (float)(c+d), (c+d)/2.0 );
		
	}
}
