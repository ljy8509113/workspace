public class CarTest{
	public static void main(String [] args){
		Car c = new Car("kia", "빨강", "레이", 2);
		
		c.start();
		c.changeGear(3);
		c.openDoor();
		c.accelerate();
		
	}
}

class Car{
	String brand;
	String color;
	String carModel;
	int year;
	int gear = 0;
	
	public Car(String brand, String color, String carModel, int year){
		this.brand = brand;
		this.color = color;
		this.carModel = carModel;
		this.year = year;
	}
	
	public void start(){
		System.out.println("시동 on");
	}
	
	public void changeGear(int gear){
		if(this.gear == gear){
			System.out.println("현제 기어와 동일합니다.");
		}else{
			this.gear = gear;
			System.out.println("기어변환 : " + gear + " 단");
		}
	}
	
	public void openDoor(){
		System.out.println("문열림");
	}
	
	public void accelerate(){
		System.out.println("가속모드");
	}
	
}