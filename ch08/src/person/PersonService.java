package person;

import java.util.List;

public class PersonService {
	
	private PersonDao dao;
	
	public PersonService() {
		this.dao = new PersonDao();
	}
	
	public void add(Person p) throws MyException {
		dao.insert(p);
	}
	
	public List<Person> read() {
		return dao.selectAll();
	}
	
	public void remove(Person p) throws MyException {
		this.dao.remove(p);
	}
	
	public void update(Person p) throws MyException{
		this.dao.update(p);
	}
}
