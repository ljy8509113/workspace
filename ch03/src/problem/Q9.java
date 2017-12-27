package problem;

import java.util.Scanner;

public class Q9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("키 몸무게 입력 : ");
		double ki = in.nextDouble();
		double kg = in.nextDouble();
		
		if(kg <= ((ki - 100) * 0.9))
			System.out.println("정상");
		else
			System.out.println("비만");		
	}
}
