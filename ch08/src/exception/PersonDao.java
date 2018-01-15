package exception;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	List<Person> list;
	public PersonDao() {
		list = new ArrayList<Person>();
	}
	
	public void insert(Person p) {
		list.add(p);
	}
	
	public List<Person> selectAll() {
		return list;
	}
}
