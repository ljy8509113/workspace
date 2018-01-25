package problem;

public class PrimeNumber03 implements Runnable{
	int limit = 0;
	
	public PrimeNumber03(int limit) {
		this.limit = limit;
	}
	
	@Override
    public void run() {
		System.out.println(Thread.currentThread().getName());
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
