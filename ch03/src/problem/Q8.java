package problem;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("�� ���� �Է� : ");
		int one = in.nextInt();
		int two = in.nextInt();
		int three = in.nextInt();
		
		int max = 0;
		int min = 0;
		
		max = one > two ? one : two;
		max = max > three ? max : three;
		min = one < two ? one : two;
		min = min > three ? three : min;
		
		System.out.printf("max : %d , min : %d", max, min);
		
		
	}
}
