package problem;

public class Employee {
	private String name;
	private int age;
	private String address;
	private String division;
	private int salary;
	
	public Employee(String name, int age, String address, String division) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.division = division;				
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setWorkHours(int workHours) {	 
	}

	public void printInfo() {
		System.out.printf("이름 : %s, 나이 : %d, 주소 %s, 부서 %s\n", this.name, this.age, this.address, this.division);
	}
	
}
