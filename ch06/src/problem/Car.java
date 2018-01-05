package problem;

public class Car {	
	
	int maxSpeed, speed;
	
	public Car(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void speedUp() {
		System.out.print("speedUp() 호출 : ");
		if(speed + 5 > maxSpeed) {
			speed = maxSpeed;
			System.out.printf("최고 속도보다 높아 최대 속도로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, speed);
		}else {
			speed+=5;
			System.out.printf("최대속도 : %d, 현제속도 : %d\n", maxSpeed, speed);
			
		}
	}
	
	public void speedUp(int speed) {
		System.out.printf("speedUp(%d) 호출 : ", speed);
		if(speed <= 0)
			System.out.printf("속도가 음수이므로 0으로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);
		else {
			if(this.speed + speed > maxSpeed) {
				this.speed = maxSpeed;
				System.out.printf("최고 속도보다 높아 최대 속도로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);
			}else {
				this.speed+=speed;
				System.out.printf("최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);			
			}
		}
		
	}
	
	public void speedDown() {
		System.out.print("speedDown() 호출");
		if(speed - 5 < 0) {
			speed = 0;
			System.out.printf("속도가 0보다 낮아 0으로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, speed);
		}else {
			speed-=5;
			System.out.printf("최대속도 : %d, 현제속도 : %d\n", maxSpeed, speed);
			
		}
	}
	
	public void speedDown(int speed) {
		System.out.printf("speedDown(%d) 호출 : ", speed);
		if(speed < 0) {
			System.out.printf("속도가 음수이므로 0으로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);
		}else {
			if(this.speed - speed < 0) {
				speed = 0;
				System.out.printf("속도가 0보다 낮아 0으로 지정, 최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);
			}else {
				this.speed-=speed;
				System.out.printf("최대속도 : %d, 현제속도 : %d\n", maxSpeed, this.speed);
			}
		}
	}
	
	public static void main(String[] args) {
		Car mycar = new Car(300);
		mycar.speedUp();
		mycar.speedUp();
		mycar.speedUp(-50);
		mycar.speedUp(50);
		mycar.speedDown(-30);
		mycar.speedDown(30);
		mycar.speedDown(30);
		mycar.speedDown(30);
		mycar.speedUp(100);
		mycar.speedUp(300);
	}
	
	
}
