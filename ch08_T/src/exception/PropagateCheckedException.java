package exception;

public class PropagateCheckedException {
	
	// 메소드 선언에서 다시 예외 ClassNotFoundException의 발생을 전달
	public static void main(String[] args) throws ClassNotFoundException {
		// 메소드 Class.forName()을 사용하려면 반드시 예외처리를 해야 함
		Class<?> forName = Class.forName("java.lang.Objec");
		System.out.println(forName);
	}
}
