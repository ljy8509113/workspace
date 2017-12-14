class Person {
	int ssn;
	String name;
	int age;
	String address;
	
	public Person(int ssn, String name, int age, String address){
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	boolean equals(Person person){
		if(this.ssn == person.ssn){
			return true;
		}else{
			return false;
		}
	}
	
}