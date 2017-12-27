package problem;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("달 입력 : ");
		int month = in.nextInt();
		
		System.out.println(month >= 6 ? "하반기 입니다." : "상반기입니다.");  
	}
}
