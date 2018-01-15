package problem;

import java.util.Calendar;

public class Q5 {
	
	static String getDay(int index) {
		String day = "";
		switch(index) {
			case 1 :
				day = "일요일";
				break;
			case 2 :
				day = "월요일";
				break;
			case 3 :
				day = "화요일";
				break;
			case 4 :
				day = "수요일";
				break;
			case 5 :
				day = "목요일";
				break;
			case 6 :
				day = "금요일";
				break;
			case 7 :
				day = "토요일";
				break;
			}
		
		return day;
	}
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.printf("오늘은 %d년 %d월 %d일 %s입니다.\n",
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DATE),
				Q5.getDay(c.get(Calendar.DAY_OF_WEEK)));
		System.out.printf("이 달의 %d번째 %s입니다.\n", c.get(Calendar.DAY_OF_WEEK_IN_MONTH), Q5.getDay(c.get(Calendar.DAY_OF_WEEK)));
		System.out.printf("이달의 %d번째 주입니다.\n", c.get(Calendar.WEEK_OF_MONTH));
		System.out.printf("이 해의 %d일 입니다.\n", c.get(Calendar.DAY_OF_YEAR));
		System.out.printf("이 해의 %d번째 주입니다.\n", c.get(Calendar.WEEK_OF_YEAR));
	}
}
