package problem;

public abstract class Fruit {	
	public abstract void print();
	
	public static void main(String[] args) {
		Fruit fAry[] = {new Grape(), new Apple(), new Pear()};
		for(Fruit f : fAry) {
			f.print();
		}
	}
}
