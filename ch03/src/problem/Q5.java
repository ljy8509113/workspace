package problem;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("년도 입력 : ");
		int year = in.nextInt();
		
		if(year%4 == 0 && year % 100 == 0 && year % 400 ==0) {
			System.out.printf("%d년은 윤년입니다.", year);	
		}else {
			System.out.printf("%d년은 평년입니다.", year);
		}	
		
	}
}
