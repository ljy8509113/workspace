package inheritance.overriding;

public class Faculty extends Person {
	public String univ;	// 소속대학
	public long number;	// 사원번호
	
	public Faculty(String name, long number, String univ, long idNumber) {
		super(name, number);
		this.univ = univ;
		this.number = idNumber;
	}
	
	public long getSNumber() {
		return super.number;	// 주민번호
	}
	
	public void printInfo() {
		System.out.print("이름: " + super.name + " 주민번호: "+super.number);
		System.out.println(" 대학:" + univ + " 직원번호: " + number);
	}
}
