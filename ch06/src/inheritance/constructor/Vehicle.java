package inheritance.constructor;

public class Vehicle {
	private String name = "차량";	// 이름
	private double maxSpeed;		// 최대속도
	private int seater;				// 정원
	
	// 기본 생성자
	public Vehicle() {
		
	}
	
	// 생성자
	public Vehicle(double maxSpeed, int seater) {
		this.maxSpeed = maxSpeed;
		this.seater = seater;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getSeater() {
		return seater;
	}

	public void setSeater(int seater) {
		this.seater = seater;
	}
}
