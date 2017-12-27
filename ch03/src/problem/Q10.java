package problem;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("금액입력 : ");
		int won = in.nextInt();
		
		int [] unit = {50000, 10000, 5000, 1000};
		String resStr = "";
		
		for(int i=0; i<unit.length; i++) {
			int a = won / unit[i];
			won = won % unit[i];
			
			if(i == unit.length-1 && won > 0) {
				a+=1;
			}
			
			resStr += unit[i]+"원권 " + a + "개\n";
		}		
		System.out.println(resStr);				
	}
}
