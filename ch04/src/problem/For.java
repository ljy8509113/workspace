package problem;

import java.util.Scanner;

public class For {
	public static void main(String [] args) {
		//1.
//		for(int i=2; i<=9; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.printf("%d * %d = %2d  ", i, j, i*j);
//			}
//			System.out.println();
//		}
		
		//2.
//		Scanner in = new Scanner(System.in);
//		System.out.println("최대 별 갯수를 입력");
//		int line = in.nextInt();
//		
//		char [][] array = new char[line][line];
//		
//		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<=i; j++) {
//				array[i][j] = '*';
//				System.out.printf("%c", array[i][j]);
//			}
//			System.out.println();
//		}
		
		//3.
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.printf("%d * %d = %2d  ", j , i, j*i );
			}
			System.out.println();
		}
		
	}
}
