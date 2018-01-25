package thread;

public class ThreadState implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			try {
				Thread.sleep(400);	// 40 밀리초 멈춤
				
				// 현재 스레드의 상태를 출력
				System.out.print(Thread.currentThread().getState() + ", ");
				
				// 현재 스레드의 이름을 출력
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
			catch (InterruptedException e) {
				System.out.println("InterruptedException이 발생되어 스레드를 종료합니다.");
				return;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("스레드의 모든 상태: 6가지");
		
		// Thread.State enum에 정의된 값들을 하나씩 출력해본 것
		for (Thread.State c : Thread.State.values()) {
			System.out.print(c + " ");
		}
		System.out.println("\n");
		
		Thread th = new Thread(new ThreadState());
		System.out.println("기본 우선순위: " + th.getPriority());
		
		// 우선순위 지정
		th.setPriority(Thread.NORM_PRIORITY + 2);
		System.out.println("우선순위 변경: " + th.getPriority());
		
		System.out.println("1 단계: " + th.getState());
		th.start();
		
		System.out.println("2 단계: " + th.getState());
		
		Thread.sleep(2000);	// main 스레드에서 실행 -> main 스레드가 2초 멈춤
		
		th.interrupt();
		System.out.println("3 단계: " + th.getState());
		
		Thread.sleep(2000); // main 스레드에서 실행 -> main 스레드가 2초 멈춤
		
		System.out.println("4 단계: " + th.getState());
	}
}
