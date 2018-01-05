package inheritance.overriding;

public class Person {
	public String name;		// 이름
	public long number;		// 주민번호
	
	public Person(String name, long number) {
		super();				// 생략가능
		this.name = name;
		this.number = number;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name +" 주민번호 : "+number);
	}
}
