package exception;

public class CheckedException {
	public static void main(String[] args) {
		// 메소드 Class.forName()을 사용하려면 반드시 예외처리를 해야 함
		Class<?> forName = null;
		try {
			forName = Class.forName("java.lang.Objec"); // 컴파일 오류
		} 
		catch (ClassNotFoundException e) {
			/*
			 *  자동 완성의 폐해
			 *  pritStackTrace()는 예외에 대한 상세한 정보를 콘솔에 출력하기 때문에,
			 *  프로그램 배포시에는 꼭 막아야 한다.
			 *  (Debug 용으로만 제발!!! 사용 바랍니다.)
			 */
			e.printStackTrace();
		}	
		System.out.println(forName.toString());
	}
}
