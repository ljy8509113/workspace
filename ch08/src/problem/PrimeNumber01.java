package problem;

public class PrimeNumber01 extends Thread{
	int limit = 0;
	public PrimeNumber01(int limit) {
		this.limit = limit;
	}
	
	@Override
    public void run() {
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
