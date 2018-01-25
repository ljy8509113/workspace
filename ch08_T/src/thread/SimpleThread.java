package thread;

class MyThread extends Thread {
	
	// �뒪�젅�뱶 湲곕뒫�쓣 援ы쁽�븯湲� �쐞�븳 硫붿냼�뱶 �옱�젙�쓽
	@Override
	public void run() {
		super.setName("aaa");
		// 湲곕뒫 援ы쁽
		for (int i = 1; i < 10; i++) {
			System.out.println(this.getName() + ": " + i 
					+ " / �떎�젣�뒪�젅�뱶: " + Thread.currentThread().getName());
		}
	}
}

public class SimpleThread {
	public static void main(String[] args) {
		MyThread th = new MyThread(); // �뒪�젅�뱶 �깮�꽦
		th.start();	// �뒪�젅�뱶 �떆�옉 硫붿냼�뱶 �샇異�
		//th.run();
		
		MyThread th2 = new MyThread();
		th2.start();
		//th2.run();
	}
}
