package inheritance.abstratinterface;

public class Abstarct{
	public static void main(String[] args) {
		Shape r = new Rectangle(2, 3, 3.67, 7.87);
		Shape c = new Circle(3, 4, 4.82);
		
		r.draw();
		c.draw();
		
		Shape sa[]  = {new Rectangle(2.5, 3.1, 1.67, 3.89), new Circle(4.2, 3.8, 1.56)};
		sa[0].draw();
		sa[1].draw();
	}
}
