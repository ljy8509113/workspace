package problem;

public class BankAccount {
	int balance = 0;
	int limit;
	public BankAccount(int limit) {
		this.limit = limit;
	}
	
	public void deposit(int money) throws InvalidWithdraw {
		//입금
		this.balance = balance(this.balance + money);
		System.out.printf("정상 입금처리: 입금금액=%d, 잔금=%d\n", money, balance);
	}
	
	public void withdraw(int money) throws InvalidWithdraw{
		//출금
		this.balance = balance(this.balance - money);
		System.out.printf("정상 출금처리: 출금금액=%d, 잔금=%d\n", money, balance);
	}
	
	int balance(int result) throws InvalidWithdraw{
		if(result < this.limit) {
			throw new InvalidWithdraw("최저 한도 " + this.balance + "원 입니다.");
		}
		return result;
	}
	
}
