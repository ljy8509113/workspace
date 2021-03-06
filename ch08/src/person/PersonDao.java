package person;


import java.util.ArrayList;
import java.util.List;

/*
 * DAO (Data Access Object): ?€?  ?°?΄?°? ? κ·Όν? κ°μ²΄λ₯? ?? ?΄??€
 * insert(Person p): ?¬? κ°μ²΄λ₯? ???₯
 * readAll(): ???₯? ?¬? ? μ²? λ¦¬μ€?Έλ₯? κ°?? Έ?€κΈ?
 */

public class PersonDao {
	List<Person> list;	// DB ??? ? ?¬?©?λ₯? ???₯?  ?λ£κ΅¬μ‘?

	public PersonDao() {
		this.list = new ArrayList<Person>();
	}
	
	public void insert(Person p) throws MyException {
		// list?? μ€λ³΅? ?Έ? ? λ³? μ°ΎκΈ°
		for (Person item : this.list) {
			// ?¬? ?΄λ¦? λΉκ΅?΄? κ°λ€λ©? μ€λ³΅? ?¬??Όλ‘? μ²λ¦¬
			if (item.equals(p)) {
				throw new MyException("E01: Person κ°μ²΄ μ€λ³΅");
			}
		}
			
		this.list.add(p);
	}
	
	public List<Person> selectAll() {
		return this.list;
	}
	
	public void remove(Person p) throws MyException{
		for(Person item : this.list) {
			if(item.equals(p)) {
				this.list.remove(item);
				return;
			}
		}
		
		throw new MyException("κ²?? κ²°κ³Όκ°? ??΅??€.");
	}
	
	public void update(Person p) throws MyException{
		for(Person item : this.list) {
			if(item.equals(p)) {
				item.setAge(p.getAge());
				return;
			}
		}
		
		throw new MyException("κ²?? κ²°κ³Όκ°? ??΅??€.");
	}
}
