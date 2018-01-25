package problem;

public class PrimeNumber02 extends Thread{
	int limit = 0;
	public PrimeNumber02(int limit, String name) {
		this.limit = limit;
		setName(name);
	}
	
	@Override
    public void run() {
		System.out.printf("%s : ", getName());
        for(int i=2; i<=limit; i++) {
        	int count = 0;
        	for(int j=2; j<=i; j++) {
        		if(i % j == 0)
        			++count;
        		if(count>1)
        			break;
        		
        		if(j == i)
        			System.out.printf("%d ", j);
        	}
        }
    }
	
}
