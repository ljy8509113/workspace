package problem;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("섭씨 온도 입력 : ");
//		Scanner in = new Scanner(System.in);
//		int c = in.nextInt();
//		
//		double f = (9.0/5.0) * c + 32;
		
		System.out.println("원금 입력 : ");
		Scanner in = new Scanner(System.in);
		int won = in.nextInt();
		
		for(int i=1; i<=10; i++) {
			double interest = (won * 0.045f) * i;
			double result = won + interest; 
			System.out.printf("%d년 단위 이자 %.0f원 (", i, interest);
			System.out.printf("만기시 : 총%.0f원)\n", result);
			
		}

	}

}
