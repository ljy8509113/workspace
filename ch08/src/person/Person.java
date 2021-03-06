package person;

//λͺ¨λΈ (Model), VO (Value Object), DTO (Data Transfer Object)
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
		// 1. μ£Όμκ°? λΉκ΅
		if (this == obj) {
			return true;
		}
		
		// 2. Person ?΄??€λ₯? ?? λ°μ?μ§? κ²??¬
		if (!(obj instanceof Person)) {
			return false;
		}
		
		// 3. Person? name ??κ°λΌλ¦? λΉκ΅
		Person p = (Person) obj;	// ?€?΄μΊμ€?
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
