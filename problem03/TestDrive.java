public class TestDrive{
	public static void main(String [] args){
		//(int hakbun, String name, int age, String major, int level){
		Student yeEun = new Student(201501, "강예은", 23, "컴.공", 3);
		Student sangIle = new Student(201602, "김상일", 45, "디자인", 2);
		Student sanghoon = new Student(201703, "정상훈", 32, "경영", 1);
		
		yeEun.study();
		yeEun.introduce();
		System.out.println("");
		sangIle.study();
		sangIle.introduce();
		System.out.println("");
		sanghoon.study();
		sanghoon.introduce();
	}
}