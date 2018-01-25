package thread;

public class SumThread implements Runnable {
	int end;
	public SumThread(int end) {
		this.end = end;
	}
	
	public void run() {
		int sum = 0;
		for(int i=1; i<= this.end; i++) {
			sum+=1;
			
			System.out.print("현제 : "+Thread.activeCount());
			System.out.print(", "+Thread.currentThread().getName());
			System.out.printf(": sum(1:%d) = %d \n",i, sum);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main s : " +Thread.currentThread().getName()  );
		System.out.print(", now :");
		System.out.print(Thread.activeCount());
		System.out.print(", 현제 쓰레드 이름 :");
		System.out.print(Thread.currentThread().getName());
		
		Runnable run = new SumThread(5);
		Thread th = new Thread(run);
		th.start();
		
		
	}
}