public class TestPuppyAdv {
	//String type, String name, int age, String gender
	public static void main(String [] args){
		PuppyAdv dog1 = new PuppyAdv("bulldog", "불독", 5, "M");
		PuppyAdv dog2 = new PuppyAdv("bulldog", "불독", 3, "G");
		
		if (dog1.equals(dog2)){
			System.out.println("같다\n");
		}else{
			System.out.println("다르다\n");
		}
		
		System.out.println("1번 : " + dog1.getName() + "\n2번 : " + dog2.getName());
		
	}
	
}