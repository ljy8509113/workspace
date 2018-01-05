package inheritance.overriding;

public class Staff extends Faculty {
	
	public String division;
	public Staff(String name, long number, String univ, long idNumber, String division) {
		super(name, number, univ, idNumber);
		this.division = division;
	}
	
	public void printInfo() {
		System.out.print("이름: " + super.name + " 주민번호: "+super.number);
		System.out.print(" 대학:" + univ + " 직원번호: " + super.number);
		System.out.println(" 부서: " + division);
	}
	
	public void printFacultyInfo() {
		super.printInfo();
	}
	
	public static void main(String[] args) {
		Person she = new Person("이소라", 2056432);
		she.printInfo();
		
		Faculty i = new Faculty("김영태", 1145782, "yunhan", 38764);
		i.printInfo();
		
		Staff he = new Staff("che young gi", 1167429, "namdo", 1287,"planning");
		he.printInfo();
		he.printFacultyInfo();
	}
}
