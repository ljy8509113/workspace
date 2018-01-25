package exception;

import java.util.regex.Pattern;

public class TestDrive {

	public static void main(String[] args) {
//		try {
//			CallForName n = new CallForName();
//			n.call();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		if(Pattern.matches("^[a-zA-Zㄱ-힣]+$", "111")){
			System.out.println("숫자");
			//숫자임

		}else{
			//숫자아님
			System.out.println("문자");

		}



	}
}
