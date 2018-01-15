package problem;

import java.util.Calendar;

public class Q6 {
	
	static String getDay(int index) {
		String day = "";
		switch(index) {
			case 1 :
				day = "일";
				break;
			case 2 :
				day = "월";
				break;
			case 3 :
				day = "화";
				break;
			case 4 :
				day = "수";
				break;
			case 5 :
				day = "목";
				break;
			case 6 :
				day = "금";
				break;
			case 7 :
				day = "토";
				break;
			}
		
		return day;
	}
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.printf("%d년 %d월 달력\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1);
		
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		for(int i = 1; i<8; i++) {
			System.out.printf("%s  ", Q6.getDay(i));	
		}
		System.out.println();
		int lastDay = c.getMaximum(Calendar.DAY_OF_MONTH);
		int current = 1;
		
		boolean isFirst = true;
		boolean isBreak = false;
		while(!isBreak) {
			for(int i=1; i<8; i++) {
				if(isFirst) {
					if(c.get(Calendar.DAY_OF_WEEK) <= i) {
						System.out.printf("%2d ", current);
						current ++;
					}else {
						System.out.print("   ");
					}
				}else {
					System.out.printf("%2d ", current);
					current ++;
				}
				
				if(current > lastDay) {
					isBreak = true;
					break;
				}
			}
			System.out.println();
			isFirst = false;
		}		
	}
}
