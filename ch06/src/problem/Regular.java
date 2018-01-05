package problem;

public class Regular extends Employee{

	int salary;
	public Regular(String name, int age, String address, String division) {
		super(name, age, address, division);
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void printInfo() {
		System.out.printf("정규직 월급 : %d원\n", this.salary);
	}
}
