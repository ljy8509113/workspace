package inheritance.typecast;

public class Instanceof {
	public static void main(String[] args) {
		Person she = new Person("이소라", 2056432);
		if(she instanceof Staff) {
			Staff st1 = (Staff)she;
		}else {
			System.out.println("she != Staff");
		}
		
		Person p = new Staff("김상기", 1187543,"kang",3456);
		if(p instanceof Staff) {
			System.out.println("p는 staff");
			Staff st2 = (Staff)p;
		}
	}
}
