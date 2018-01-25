package waite;

import java.util.Random;

class BankAccount {
	int balance = 0;	// �����ܰ�
	int diff = 0;
	
	// ����
	public synchronized void withdraw(int money) {
		// ���� ����Ϸ��� �ݾ׺��� �ܰ� ������ �˻�
		
		if(money < 0) {
			System.out.println("���� �ݾ��� �߸��ƽ��ϴ�.");
			return;
		}
		
		int count = 0;
		while(balance < money) {
			System.out.printf("[%s] ", Thread.currentThread().getName());
			if(++count > 3) {
				System.out.println("�ܾ��� �����Ͽ� ���ó�� ���ϰ� �����մϴ�.");
				break;
			}
			
			System.out.printf("%16s", "wait(1000) ȣ��:" );
			System.out.printf("����䱸�ݾ�=%6d %n", money, balance);
			
			try {
				wait(1000);
			}catch(InterruptedException e) {
				System.out.println("InterruptedException");
			}
			
			System.out.printf("[%s] ", Thread.currentThread().getName());
			balance -= money;
			System.out.printf("%12s ��������ݾ�=%6d, balance=%6d %n", "��� ���ó��:", money, balance);
			
		}
		
	}
	
	// �Ա�
	public void deposit(int money) {
		synchronized(this) {
			if (money < 0) {
				System.out.println("�Ա� �ݾ� ����");
				return;
			}
			
			RuntimeException
			
			balance += money;
			System.out.printf("[%s] ", Thread.currentThread().getName());
			System.out.printf("%16s", "notify() ȣ��: ");
			System.out.printf("�����Աݱݾ�=%6d, balance=%6d %n", money, balance);
			notifyAll();
		}		
	}
	
	
}

public class SyncTest implements Runnable {
	BankAccount act = new BankAccount();

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			int amount = (int)(new Random().nextDouble() * 5 + 1) * 10000;	// 0 ~ 10000���� �������ڸ� ������ ����.
			act.deposit(amount);
			amount = (int)(new Random().nextDouble() * 5 + 1) * 10000;	// 0 ~ 10000���� �������ڸ� ������ ����.
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
//		th1.setName("ö��");
//		th2.setName("����");
//		
//		th1.start();
//		th2.start();
	}
}




