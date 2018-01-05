package problem;

import java.util.Scanner;

public class Person extends Student {
	String name;
	int age;
	String address;
	
	public Person(String name, int age, String address, String school, String department, int studentId) {
		super(school, department, studentId);
		this.name = name;
		this.age = age;
		this.address = address;				
	}
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %d\n", age);
		System.out.printf("주소 : %s\n", address);
		System.out.printf("학교 : %s\n", school);
		System.out.printf("학과 : %s\n", department);
		System.out.printf("학번 : %d\n", studentId);
		System.out.println("===============================");
		
	}
	
	public static void main(String[] args) {
		Person p = new Person("김다정", 20, "서울시 관악구", "동양서울대학교", "전산정보학과", 2013222);
		p.printInfo();
		Scanner in = new Scanner(System.in);
		System.out.println("8학기 학점을 순서대로 입력하세요.");
		for(int i=0; i<p.grade.length; i++) {
			System.out.printf("%d 학기 학점 ->", i+1);
			p.grade[i] = in.nextDouble();
		}
		System.out.println("==================================");
		System.out.printf("8학기 총 편균 평점은 %f점입니다.", p.average());
		
	}
	
}
