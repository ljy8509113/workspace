public class Puppy{
	String type;
	String name;
	int age;
	String gender;
	
	public Puppy(String type, String name, int age, String gender){
		this.type = type;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	boolean equals(Puppy p){
		if( this.type.equals(p.type) && this.name.equals(p.name)){
			return true;
		}else{
			return false;
		}
	}
	
	String getName(){
		return "Type : " + type + " // Name : " + name;
	}
	
}