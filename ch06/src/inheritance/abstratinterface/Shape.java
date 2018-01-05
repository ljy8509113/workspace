package inheritance.abstratinterface;

public abstract class Shape {
	protected double x, y;
	
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;		
	}
	
	public void drawCenter() {
		System.out.println("중심좌표 (x, y) = " + x + ", " + y);
	}
	
	public abstract void draw();
	public static void main(String[] args) {
		
	}
}
