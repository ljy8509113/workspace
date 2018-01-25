package thread;

public class SumThread implements Runnable {
	
	private int end;
	
	public SumThread(int end) {
		this.end = end;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i = 1; i <= this.end; i++) {
			sum += i;
			/*System.out.print("현재 스레드 수: " + Thread.activeCount());
			System.out.print(", " + Thread.currentThread().getName());
			System.out.printf(": sum(1:%d) = %d %n", i, sum);*/
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		// main 스레드가 main() 메소드를 호출하므로 이 부분에도 스레드가 이미 실행
		System.out.print("main 스레드 ID: ");
		System.out.print(Thread.currentThread().getId());
		System.out.print(", 현재 스레드 수: ");
		System.out.print(Thread.activeCount());
		System.out.print(", 현재 스레드 이름: ");
		System.out.println(Thread.currentThread().getName());
		
		// 직접 구현한 스레드를 실행
		Runnable r1 = new SumThread(5);
		Thread th1 = new Thread(r1);
		// 우선순위 조정
		th1.setPriority(Thread.MIN_PRIORITY);
		
		// 직접 구현한 스레드를 실행
		Runnable r2 = new SumThread(5);
		Thread th2 = new Thread(r2);
		// 우선순위 조정
		th2.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		th2.start();
		
		/*System.out.print("main 스레드 ID: ");
		System.out.print(Thread.currentThread().getId());
		System.out.print(", 현재 스레드 수: ");
		System.out.print(Thread.activeCount());
		System.out.print(", 현재 스레드 이름: ");
		System.out.println(Thread.currentThread().getName());*/
		
		// main 스레드의 우선순위 값은 얼마인가?
		System.out.println("main 스레드 우선순위: " + Thread.currentThread().getPriority());
		
		// th1의 스레드 우선순위
		System.out.println("th1 스레드 우선순위: " + th1.getPriority());
	}
}
