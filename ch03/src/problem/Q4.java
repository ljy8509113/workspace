package problem;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("kg 입력 : ");
		double a = in.nextDouble();
		
		double c = a * 0.453592;
		
		System.out.printf("파운드 : %.3f", c );
		
	}
}
