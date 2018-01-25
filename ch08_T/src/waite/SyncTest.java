package waite;

import java.util.Random;

class BankAccount {
	int balance = 0;	// 은행잔고
	int diff = 0;
	
	// 인출
	public synchronized void withdraw(int money) {
		// 현재 출금하려는 금액보다 잔고가 많은지 검사
		
		if(money < 0) {
			System.out.println("인출 금액이 잘못됐습니다.");
			return;
		}
		
		int count = 0;
		while(balance < money) {
			System.out.printf("[%s] ", Thread.currentThread().getName());
			if(++count > 3) {
				System.out.println("잔액이 부족하여 출금처리 못하고 종료합니다.");
				break;
			}
			
			System.out.printf("%16s", "wait(1000) 호출:" );
			System.out.printf("인출요구금액=%6d %n", money, balance);
			
			try {
				wait(1000);
			}catch(InterruptedException e) {
				System.out.println("InterruptedException");
			}
			
			System.out.printf("[%s] ", Thread.currentThread().getName());
			balance -= money;
			System.out.printf("%12s 정상인출금액=%6d, balance=%6d %n", "장상 출금처리:", money, balance);
			
		}
		
	}
	
	// 입금
	public void deposit(int money) {
		synchronized(this) {
			if (money < 0) {
				System.out.println("입금 금액 오류");
				return;
			}
			
			RuntimeException
			
			balance += money;
			System.out.printf("[%s] ", Thread.currentThread().getName());
			System.out.printf("%16s", "notify() 호출: ");
			System.out.printf("계좌입금금액=%6d, balance=%6d %n", money, balance);
			notifyAll();
		}		
	}
	
	
}

public class SyncTest implements Runnable {
	BankAccount act = new BankAccount();

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			int amount = (int)(new Random().nextDouble() * 5 + 1) * 10000;	// 0 ~ 10000까지 랜덤숫자를 끄집어 낸다.
			act.deposit(amount);
			amount = (int)(new Random().nextDouble() * 5 + 1) * 10000;	// 0 ~ 10000까지 랜덤숫자를 끄집어 낸다.
			act.withdraw(amount);
		}
		
	}
	
	public static void main(String[] args) {
		Runnable r = new SyncTest();
		new Thread(r).start();
		new Thread(r).start();
//		Thread th1 = new Thread(r);
//		Thread th2 = new Thread(r);
//		
//		th1.setName("철수");
//		th2.setName("영희");
//		
//		th1.start();
//		th2.start();
	}
}




