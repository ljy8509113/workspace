public class TestCalc {
	//String type, String name, int age, String gender
	public static void main(String [] args){
		Calc c = new Calc();
		int a = 5;
		int b = 2;
		System.out.println(a + "와 " + b + "의 합" + c.add(a, b));
		System.out.println(a + "와 " + b + "의 차" + c.sub(a, b));
		System.out.println(a + "와 " + b + "의 곱" + c.mul(a, b));
		System.out.println(a + "와 " + b + "의 나눔" + c.div(a, b));		
	}	
}