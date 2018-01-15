package problem;

public abstract class Complex {	
	double mistake; //실수
	double imaginary; //허수
	
	public Complex(double mistake, double imaginary) {
		this.mistake = mistake;
		this.imaginary = imaginary;
	}
	
	public double abs(Complex c) {
		return Math.sqrt(c.mistake * c.mistake + c.imaginary * c.imaginary);
	}
	
	public void print() {
		System.out.printf("%f + %fi", mistake, imaginary);
	}
	
}
