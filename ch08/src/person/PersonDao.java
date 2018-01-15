package person;


import java.util.ArrayList;
import java.util.List;

/*
 * DAO (Data Access Object): ?��?�� ?��?��?��?�� ?��근하?�� 객체�? ?��?�� ?��?��?��
 * insert(Person p): ?��?�� 객체�? ???��
 * readAll(): ???��?�� ?��?�� ?���? 리스?���? �??��?���?
 */

public class PersonDao {
	List<Person> list;	// DB ???��?�� ?��?��?���? ???��?�� ?��료구�?

	public PersonDao() {
		this.list = new ArrayList<Person>();
	}
	
	public void insert(Person p) throws MyException {
		// list?��?�� 중복?�� ?��?��?���? 찾기
		for (Person item : this.list) {
			// ?��?�� ?���? 비교?��?�� 같다�? 중복?�� ?��?��?���? 처리
			if (item.equals(p)) {
				throw new MyException("E01: Person 객체 중복");
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
		
		throw new MyException("�??�� 결과�? ?��?��?��?��.");
	}
	
	public void update(Person p) throws MyException{
		for(Person item : this.list) {
			if(item.equals(p)) {
				item.setAge(p.getAge());
				return;
			}
		}
		
		throw new MyException("�??�� 결과�? ?��?��?��?��.");
	}
}
