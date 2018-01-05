package problem;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] ary = {
				{78,48,78,98},
				{99,92},
				{29,64,83},
				{34,78,92,56}
		};
		
		for(int i=0; i<ary.length; i++) {
			int sum = 0;
			float avg = 0;
			for(int j=0; j<ary[i].length; j++) {
				System.out.printf("%d ", ary[i][j]);
				sum += ary[i][j];
				if(j == ary[i].length-1) {
					avg = (float)sum / (float)(j+1);
					System.out.printf(" 합 : %d, 평균:%f\n", sum, avg);
				}
			}
		}

	}

}
