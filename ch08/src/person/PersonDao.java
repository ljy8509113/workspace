package person;


import java.util.ArrayList;
import java.util.List;

/*
 * DAO (Data Access Object): ?‹¤? œ ?°?´?„°?— ? ‘ê·¼í•˜?Š” ê°ì²´ë¥? ?œ„?•œ ?´?˜?Š¤
 * insert(Person p): ?‚¬?Œ ê°ì²´ë¥? ???¥
 * readAll(): ???¥?œ ?‚¬?Œ ? „ì²? ë¦¬ìŠ¤?Š¸ë¥? ê°?? ¸?˜¤ê¸?
 */

public class PersonDao {
	List<Person> list;	// DB ???‹ ?— ?‚¬?š©?ë¥? ???¥?•  ?ë£Œêµ¬ì¡?

	public PersonDao() {
		this.list = new ArrayList<Person>();
	}
	
	public void insert(Person p) throws MyException {
		// list?—?„œ ì¤‘ë³µ?œ ?¸? ? •ë³? ì°¾ê¸°
		for (Person item : this.list) {
			// ?‚¬?Œ ?´ë¦? ë¹„êµ?•´?„œ ê°™ë‹¤ë©? ì¤‘ë³µ?œ ?‚¬?Œ?œ¼ë¡? ì²˜ë¦¬
			if (item.equals(p)) {
				throw new MyException("E01: Person ê°ì²´ ì¤‘ë³µ");
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
		
		throw new MyException("ê²??ƒ‰ ê²°ê³¼ê°? ?—†?Šµ?‹ˆ?‹¤.");
	}
	
	public void update(Person p) throws MyException{
		for(Person item : this.list) {
			if(item.equals(p)) {
				item.setAge(p.getAge());
				return;
			}
		}
		
		throw new MyException("ê²??ƒ‰ ê²°ê³¼ê°? ?—†?Šµ?‹ˆ?‹¤.");
	}
}
