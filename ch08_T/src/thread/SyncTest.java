package thread;

import java.util.Random;

class BankAccount {
	int balance = 0;	// �����ܰ�
	
	// ����
	public synchronized void withdraw(int money) {
		// ���� ����Ϸ��� �ݾ׺��� �ܰ� ������ �˻�
		if (money >= 0 && this.balance >= money) {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				System.out.println(e);
			}
			this.balance -= money;
			System.out.printf("%s�� %d �����Ͽ� �����ܰ� %d�Դϴ�. %n", 
					Thread.currentThread().getName(), money, this.balance);
		}
		else if (this.balance < money) {
			System.out.println("�ܰ� �����Ͽ� ������ �� �����ϴ�.");
		}
	}
	
	// �Ա�
	public void deposit(int money) {
		synchronized(this) {
			if (money > 0) {
				this.balance += money;
				System.out.printf("%s�� %d �Ա��Ͽ� �����ܰ� %d�Դϴ�. %n", 
						Thread.currentThread().getName(), money, this.balance);
			}
		}
		
	}
}

public class SyncTest implements Runnable {
	BankAccount act = new BankAccount();

	@Override
	public void run() {
		while (true) {
			int amount = new Random().nextInt(10000);	// 0 ~ 10000���� �������ڸ� ������ ����.
			amount = amount % 10 * 1000;	// 10���� ���� �������̱� ������ 1�� �ڸ����� 1000�� ���� ��
			System.out.printf("[%s] �ݾ�=%d %n", Thread.currentThread().getName(), amount);
			act.deposit(amount);		// �Ա�
			act.withdraw(amount * 2);	// ��� (2��� �� ������ �ܰ� �ٴڳ��� �ϱ� ���ؼ�)
			if (act.balance < 0) {
				System.out.printf("[%s] ", Thread.currentThread().getName());
				System.out.println("�ܰ�: " + act.balance + " => ���� ����");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable r = new SyncTest();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.setName("ö��");
		th2.setName("����");
		
		th1.start();
		th2.start();
	}
}




