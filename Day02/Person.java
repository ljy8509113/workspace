public class Person{
	int headSize;
	int height;
	String gender;
	int age;
	String name;
	String family;
	
	public Person(int headSize, int height, String gender, int age, String name, String family){
		this.headSize = headSize;
		this.height = height;
		this.gender = gender;
		this.name = name;
		this.family = family;
	}
	
	String eat(String food){
		if(food.equals("빵")){
			return name + "은(는) 배부르다";
		}else{
			return name + "은(는) 배고프다";
		}
	}
	
	String sleep(String where){
		if(where.equals("땅바닥")){
			return name + "은(는) 피곤하다";
		}else{
			return name + "은(는) 꿀잠잤다";
		}
	}
	
	void work(String where){
		System.out.println(name + "은(는) " + where + " 위로 걷는다");
	}
	
	void think(String how){
		System.out.println(name + "은(는) " + how + " (을)를 생각한다");
	}
	
	int add(int a, int b){
		return a+b;
	}
}