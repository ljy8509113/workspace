package inheritance.abstratinterface.test;

public class Chinese extends Process{
	
	public Chinese(int x, int y) {
		super(x,y);
	}
	
	public void cooking() {
		System.out.println("중국 요리");
	}
	
	public void delivering() {
		System.out.println("중국집 배달");
	}
	
	public void ordering() {
		System.out.println("중국집 주문");
	}
	
	public void payment() {
		System.out.println("중국요리 계산");
	}
}
