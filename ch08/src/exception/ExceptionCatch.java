package exception;

import java.io.IOException;

public class ExceptionCatch {
	public static void main(String[] args) {
		try {
			int data = Integer.parseInt("1");
		}catch(Exception e) {
			
		}finally {
			System.out.println("finally");
		}
	}
}
