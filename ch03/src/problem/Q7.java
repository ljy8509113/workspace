package problem;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("�� �Է� : ");
		int month = in.nextInt();
		
		System.out.println(month >= 6 ? "�Ϲݱ� �Դϴ�." : "��ݱ��Դϴ�.");  
	}
}
