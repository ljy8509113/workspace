package exception;

public class CallForName {
	public void call() throws  ClassNotFoundException{
		Class<?> c = Class.forName("java.lang.Objec");
		System.out.println(c);
	}
}
