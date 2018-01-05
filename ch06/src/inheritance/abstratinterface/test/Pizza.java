package inheritance.abstratinterface.test;

public class Pizza extends Process {
	
	public Pizza(int x, int y) {
		super(x, y);
	}
	
	public void cooking() {
		System.out.println("피자 요리");
	}
	
	public void delivering() {
		System.out.println("피자 배달");
	}
	
	public void ordering() {
		System.out.println("피자 주문");
	}
	
	public void payment() {
		System.out.println("피자 계산");
	}
	
}
