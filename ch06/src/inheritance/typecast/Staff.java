package inheritance.typecast;

public class Staff extends Faculty {
	
	public String division;
	public String name = "staff";
	public Staff(String name, long number, String univ, long idNumber) {
		super(name, number, univ, idNumber);
	}
}
