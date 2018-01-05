package body.check;

public class Professor extends Person{
	String dept;
	
//	public Professor(String dept) {
//		this.dept = dept;
//	}
	
	//6-2, 6-3 위 생성자를 수정 아래처럼
	public Professor(String dept, String name) {
		super(name);
		this.dept = dept;
	}
}
