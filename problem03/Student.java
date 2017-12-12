public class Student{
	int hakbun;
	String name;
	int age;
	String major;
	int level;
	
	public Student(int hakbun, String name, int age, String major, int level){
		this.hakbun = hakbun;
		this.name = name;
		this.age = age;
		this.major = major;
		this.level = level;
	}
	
	public void study(){
		System.out.println("["+name+"] (이)가 [" +major + "] 공부를 한다.");		
	}

	public void introduce(){
		System.out.println("저는 [" + major + "] [" + level + "] 학년 재학중인 [" + name + "] 입니다.");		
	}		
	
}