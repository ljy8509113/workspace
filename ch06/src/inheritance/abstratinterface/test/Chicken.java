package inheritance.abstratinterface.test;

public class Chicken extends Process{
	
	public Chicken(int x, int y) {
		super(x, y);
	}
	
	public void cooking() {
		System.out.println("치킨 요리");
	}
	
	public void delivering() {
		System.out.println("치킨 배달");
	}
	
	public void ordering() {
		System.out.println("치킨 주문");
	}
	
	public void payment() {
		System.out.println("치킨 계산");
	}
	
}
