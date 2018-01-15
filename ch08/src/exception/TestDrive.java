package exception;

public class TestDrive {

	public static void main(String[] args) {
		try {
			CallForName n = new CallForName();
			n.call();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
