package problem;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("�⵵ �Է� : ");
		int year = in.nextInt();
		
		if(year%4 == 0 && year % 100 == 0 && year % 400 ==0) {
			System.out.printf("%d���� �����Դϴ�.", year);	
		}else {
			System.out.printf("%d���� ����Դϴ�.", year);
		}	
		
	}
}
