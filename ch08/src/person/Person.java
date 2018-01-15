package person;

//ëª¨ë¸ (Model), VO (Value Object), DTO (Data Transfer Object)
public class Person {
	
	private String name;
	private Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 1. ì£¼ì†Œê°? ë¹„êµ
		if (this == obj) {
			return true;
		}
		
		// 2. Person ?´?˜?Š¤ë¥? ?ƒ?† ë°›ì•˜?Š”ì§? ê²??‚¬
		if (!(obj instanceof Person)) {
			return false;
		}
		
		// 3. Person?˜ name ?•„?“œê°’ë¼ë¦? ë¹„êµ
		Person p = (Person) obj;	// ?‹¤?š´ìºìŠ¤?Œ…
		if (this.name.equals(p.name)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
}
