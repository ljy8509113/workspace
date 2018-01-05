package problem;

public class Q1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		String str = "";
		for(int i=1; i<=100; i++) {
			if(i%2 == 0 || i%3 == 0 || i%5 == 0 || i%7 == 0) {
				continue;
			}else {
				 str += i + " ";
				 count += 1;
				 if(count == 10) {
					 count = 0;
					 System.out.println(str);
					 str = "";
				 }
			}
			
			
		}
		
	}

}
