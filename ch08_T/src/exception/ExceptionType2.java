package exception;

public class ExceptionType2 {
	public static void main(String[] args) {
		String[] str = {"안녕하세요!", "Hello!"};
		
		System.out.println(str[0]);
		System.out.println(str[2]);		// 예외발생
		System.out.println(str[1]);
	}
}
