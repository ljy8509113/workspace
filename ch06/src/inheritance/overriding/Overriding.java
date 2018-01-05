package inheritance.overriding;

public class Overriding {
	public static void main(String[] args) {
		Person she = new Person("이소라", 2056432);
		she.printInfo();
		
		Person i = new Faculty("김영태", 1145782, "연한대", 38764);
		i.printInfo();
		
		Person he = new Staff("che young gi", 1167429, "namdo", 1287,"planning");
		he.printInfo();
		Faculty f = (Faculty)he;
		f.printInfo();
		Staff s = (Staff)he;
		s.printInfo();
	}
}
