package exception;

public class PersonService {

	private PersonDao dao;
	
	public PersonService() {
		dao = new PersonDao();
	}
	
	public void add(Person p) {
		dao.insert(p);
	}
}
