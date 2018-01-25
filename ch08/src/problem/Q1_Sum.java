package problem;

import java.util.Scanner;

public class Q1_Sum {
	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
			System.out.println("정수 2개를 입력: ");
			x = input.nextInt();
			y = input.nextInt();
			break;
			}catch(Exception e) {
				System.out.println("정수만 입력가능합니다.");
				input.nextLine();
				continue;
			}
		}
		
		z = x+y;
		System.out.printf("%d + %d = %d",x,y,z);
		input.close();
	}
}
