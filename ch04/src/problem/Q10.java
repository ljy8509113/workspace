package problem;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] array = {
//				{1},
//				{1,1},
//				{1,2,1},
//				{1,3,3,1},
//				{1,4,6,4,1},
//				{1,5,10,10,5,1},
//				{1,6,15,20,15,6,1},
//				{1,7,21,35,35,21,7,1},
//				{1,8,28,56,70,56,28,8,1},
//				{1,9,36,84,126,126,84,36,9,1}
				{0},
				{0,0},
				{0,0,0},
				{0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0}
		};
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				if(i>1) {
					if(j == 0 || j == array[i].length-1) {
						array[i][j] = 1;
					}else {
						array[i][j] = array[i-1][j-1] + array[i-1][j]; 
					}
				}else {
					array[i][j] = 1;
				}
				
				if(j == array[i].length-1)
					System.out.printf("%d \n", array[i][j]);
				else
					System.out.printf("%d ", array[i][j]);
			}
		}

	}

}
