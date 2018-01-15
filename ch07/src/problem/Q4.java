package problem;

import java.util.Calendar;
import java.util.Scanner;

public class Q4 {
	
	public static void main(String[] args) {
		int year, month, day;
		System.out.println("년 월 일 을 입력하세요.");
		Scanner in = new Scanner(System.in);
		System.out.printf("년 : ");
		year = in.nextInt();
		System.out.printf("월 : ");
		month = in.nextInt();
		System.out.printf("일 : ");
		day = in.nextInt();
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		
		System.out.println(c.getTime());
	}
}
