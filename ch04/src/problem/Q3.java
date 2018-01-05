package problem;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("숫자를 입력 : ");
		Scanner in = new Scanner(System.in);
		String num = in.next(); 
		
		int i = num.length()-1;
		do {
			System.out.printf("%c", num.charAt(i));
			i--;
		}while(i >= 0);
		
	}

}
