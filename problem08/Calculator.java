public class Calculator{
	public static void main( String [] args ){
		/*
		if(args.length != 3){
			for(int i=0; i<args.length;i++)
				System.out.println(i + " : " + args[i]);
			System.out.println("입력 오류 입력예시(숫자 연산자 숫자) : 4 + 5 length : " + args.length);
		}else{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[2]);
			String operator = args[1];
			
			int result = 0;
			if(operator.equals("+")){
				result = a+b;
			}else if(operator.equals("-")){
				result = a-b;
			}else if(operator.equals("*")){
				result = a*b;
			}else if(operator.equals("/")){
				result = a/b;
			}else{
				System.out.println("연산자 입력 오류 : +, -, *, /");
				return;
			}
			
			System.out.println(a + " " + operator + " " + b + " = " + result);
			
		}
		*/
		
		Calc c = new Calc();
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		System.out.println(a + "와 " + b + "의 합 : " + c.add(a, b));
		System.out.println(a + "와 " + b + "의 차 : " + c.sub(a, b));
		System.out.println(a + "와 " + b + "의 곱 : " + c.mul(a, b));
		System.out.println(a + "와 " + b + "의 나눔 : " + c.div(a, b));
		
	}
}