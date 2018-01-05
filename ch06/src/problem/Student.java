package problem;

public class Student{
	String school;
	String department;
	int studentId;
	double [] grade = new double[8];
	
	public Student(String school, String department, int studentId) {
		this.school = school;
		this.department = department;
		this.studentId = studentId;
	}
	
	public double average() {
		double total = 0.0;
		for(double i : grade) {
			total += i;
		}
		return total / grade.length; 
	}
	
}
