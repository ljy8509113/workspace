package problem;

import java.util.HashSet;
import java.util.Scanner;

public class Q7 {
	
	public static void main(String[] args) {
		System.out.println("표준입력으로 문자열을 여러줄에 입력하세요.\n결과를 보시려면 마지막에 표준입력으로 quit를 입력하세요.");
		Scanner in = new Scanner(System.in);
		boolean isNext = true;
		HashSet<String> hSet = new HashSet<>();
		HashSet<String> dSet = new HashSet<>();
		while(isNext) {
			String str = in.next();
			if(str.equals("quit")) {
				isNext = false;
			}else {
				if(hSet.contains(str)) {
					dSet.add(str);
				}else {
					hSet.add(str);
				}
				
			}
		}
		
		System.out.println("중복되지 않은 문자열 -> " + hSet.toString());
		System.out.println("중복되는 문자열 -> " + dSet.toString());
		
	}
}
