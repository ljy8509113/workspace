package problem;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		System.out.println("���� �Է�(õ������) : ");
		int num = in.nextInt();
		int imsi = num;
		
		int m = imsi/10000;
		imsi -= m*10000; 
		
		int s = imsi / 1000;
		imsi -= s*1000;
		
		int h = imsi / 100;
		imsi -= h*100;
		
		int t = imsi / 10;
		imsi -= t*10;
		
		System.out.println(m+"��"+s+"õ"+h+"��"+t+"��"+imsi);
	}
}
