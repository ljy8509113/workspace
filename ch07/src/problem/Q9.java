package problem;

import java.util.HashMap;
import java.util.Scanner;

public class Q9 {
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap();
		map.put("김미현", "010-3675-8754");
		map.put("김일현", "010-3675-8700");
		map.put("김삼현", "010-3675-0000");
		
		System.out.println("검색할 이름을 적으세요.");
		Scanner in = new Scanner(System.in);
		String key = in.next();
		String phoneNumber = map.get(key); 
		
		
		if(phoneNumber != null) {
			System.out.printf("입력하신 %s의 전화번호는 %s입니다.",key, phoneNumber);
		}else {
			System.out.printf("검색결과가 없습니다.");
		}
	}
}
