package inheritance.abstratinterface.test;

public abstract class Process {
	static int x = 0, y= 0;
	public Process(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void cooking();
	public abstract void delivering();
	public abstract void ordering();
	public abstract void payment();
	
	public void processing() {
		this.ordering();
		this.cooking();
		this.delivering();
		this.payment();
	}
	
	public static void main(String [] args) {
		Process chicken = new Chicken(1,2);
		Process chinese = new Chinese(2,3);
		Process pizza = new Pizza(5, 10);
		
		Process [] stores = new Process[3];
		stores[0] = chicken;
		stores[1] = chinese;
		stores[2] = pizza;
		
		for(int i=0; i<stores.length; i++) {
			stores[i].cooking();
		}
		
		System.out.println(x+y+"");
	}
	
}
