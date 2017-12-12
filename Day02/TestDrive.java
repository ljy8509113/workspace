public class TestDrive{
	public static void main(String [] args){
		//(int headSize, int height, String gender, int age, String name, String family){
		Person yeEun = new Person(10, 163, "여", 23, "강예은", "A");
		Person sangIle = new Person(10, 173, "남", 45, "김상일", "B");
		Person sangHun = new Person(10, 177, "남", 32, "정상훈", "C");
		
		String result = yeEun.eat("빵");
		System.out.println(result);
		
		String result2 = sangIle.sleep("침대");
		System.out.println(result2);
		
		sangHun.work("물");
		sangHun.think("비트코인");
	}
}