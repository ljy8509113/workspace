package problem;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("max(숫자) 입력 : ");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			if(sum+i > 5000) {
				System.out.printf("%d %d", i, sum);
				break;
			}else {
				sum += i;
				if(i == num)
					System.out.printf("%d %d",i, sum);
			}			
		}

	}

}
