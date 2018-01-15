package com.test.code.bean;

public class Student {
	private int studentId;
	private String name;
	
	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + this.studentId;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += this.studentId + ", "+this.name;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(obj.hashCode() == this.hashCode())
			return true;
		
		if(obj.getClass() != this.getClass()) 
			return false;
		
		if(obj instanceof Student) {
			if( ((Student)obj).studentId == this.studentId )
				return true;
			else
				return false;	
		}else {
			return false;
		}		
	}
	
	public static void main(String[] args) {
		Student a = new Student();
		a.setName("홍길동");
		a.setStudentId(1000);
		
		Student b = new Student();
		b.setName("김길동");
		b.setStudentId(1001);
		
		Student c = new Student();
		c.setName("홍길동");
		c.setStudentId(1000);
		
		if(a.equals(b))
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		
		try {
			
		}catch() {
			
		}finally {
			
		}
		
	}
	
}
