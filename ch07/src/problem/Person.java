package problem;

public class Person {
	String name;
	
	public Person(String name){
		this.name = name;
	}
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person s = (Person)obj;
	        return (this.name.equals(s.name));
		}else {
			return false;
		}		
    }
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		System.out.println(p1.equals(new Person("홍길동")));
		System.out.println(p1.equals(new Person("최영태")));
	}
}
