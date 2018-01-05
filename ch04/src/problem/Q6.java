package problem;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("섭씨 온도 입력 : ");
//		Scanner in = new Scanner(System.in);
//		int c = in.nextInt();
//		
//		double f = (9.0/5.0) * c + 32;
		
		for(int i=-60; i<=140; i+=20) {
			double f = (9.0/5.0) * i + 32;
			System.out.printf("%3dC -> %3.0fF\n", i, f);
		}

	}

}
