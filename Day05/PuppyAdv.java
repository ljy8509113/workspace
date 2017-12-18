public class PuppyAdv{
	String type;
	String name;
	int age;
	String gender;
	
	public PuppyAdv(String type, String name, int age, String gender){
		this.type = type;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	boolean equals(PuppyAdv p){
		if( this.type == p.type && this.name == p.name){
			return true;
		}else{
			return false;
		}
	}
	
	String getName(){
		return "Type : " + type + " // Name : " + name;
	}
	
}