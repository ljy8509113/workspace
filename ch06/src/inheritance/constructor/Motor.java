package inheritance.constructor;

public class Motor extends Vehicle {
	private String name = "자동차";	// 이름
	private int displacement;		// 배기량
	
	// Motor의 기본 생성자
	public Motor() {
		/*
		 *  부모가 존재해야 자식이 존재할 수 있기 때문에
		 *  항상 부모의 생성자를 먼저 한번 호출해야 한다.
		 */
		super();	// Vehicle(); 생략가능 (컴파일러가 알아서 자동으로 생성)
	}
	
	public Motor(double maxSpeed, int seater, int displacement) {
		super(maxSpeed, seater);
		//this.maxSpeed = maxSpeed;
		//this.seater = seater;
		this.displacement = displacement;
	}
	
	public void printInfo() {
		System.out.print(super.getName() + ": " + this.name);
		System.out.println(", 최대속도: " + this.getMaxSpeed() + " km");
		System.out.print("정원: " + this.getSeater() + " 명");
		System.out.println(", 배기량: " + this.displacement + " cc");
	}
	
	public static void main(String[] args) {
		Motor myCar = new Motor(300, 4, 5000);
		myCar.printInfo();
	}

}
