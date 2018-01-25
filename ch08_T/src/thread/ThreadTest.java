package thread;

class IncThread extends Thread {
	// 생성자 구현
	public IncThread(String name) {
		this.setName(name);	// 스레드 이름 입력
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(50);	// 50 밀리초 동안에 잠깐 쉬어라 (1000밀리초 = 1초)
				/*System.out.print(this.getName() + ": " + i);
				System.out.println(", 활성화된 스레드 수: " + Thread.activeCount());*/
				System.out.println(this.getName() + ": " + i + ", 활성화된 스레드 수: " + Thread.activeCount());
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class DecThread extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 1; i--) {
			try {
				Thread.sleep(50);
				/*System.out.print(this.getName() + ": " + i);
				System.out.println(", 활성화된 스레드 수: " + Thread.activeCount());*/
				System.out.println(this.getName() + ": " + i + ", 활성화된 스레드 수: " + Thread.activeCount());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		IncThread inc = new IncThread("증가 스레드");
		inc.start();
		
		DecThread dec = new DecThread();
		dec.start();
	}
}
