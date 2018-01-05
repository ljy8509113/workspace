package problem;

public class Temporary extends Employee{
	int workHours;
	int hourlyWage = 10000;
	int salary;
	
	public Temporary(String name, int age, String address, String division) {
		super(name, age, address, division);
	}
	
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
		this.salary = this.workHours * this.hourlyWage; 
	}
	
	public void printInfo() {
		System.out.printf("비정규직 일한 시간 : %d 급여 : %d원\n", this.workHours, this.salary);
	}
	
	public static void main(String[] args) {
//		Regular r = new Regular("이순신", 35, "서울", "인사부");
//		Temporary t = new Temporary("장보고", 25, "인천", "경리부");
//		
//		r.setSalary(5000000);
//		r.printInfo();
//		
//		t.setWorkHours(120);
//		t.printInfo();
		
		Employee r = new Regular("이순신", 35, "서울", "인사부");
		Employee t = new Temporary("장보고", 25, "인천", "경리부");
		
		r.setSalary(5000000);
		r.printInfo();
		
		t.setWorkHours(120);
		t.printInfo();
	}
}
