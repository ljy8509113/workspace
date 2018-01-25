package problem;

import java.util.Date;

public class PrintTime implements Runnable{

	int printCount;
	public PrintTime(int printCount) {
		this.printCount = printCount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t =Thread.currentThread();
		for(int i=0; i<this.printCount; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("순위: %d %s %s\n", t.getPriority(), new Date(), t.getName());
		}
	}
	
}
