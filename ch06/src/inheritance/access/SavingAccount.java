package inheritance.access;

public class SavingAccount extends Account {
	
	public double rates;	// 이자율
	
	public SavingAccount(String name, int number, double rates) {
		super(name, number);
		this.rates = rates;
	}
	
	public static void main(String[] args) {
		SavingAccount myAccount = new SavingAccount("김태희", 234567654, 0.34);
		myAccount.deposit(400000);
		myAccount.withdraw(50000);
		myAccount.checkBalance();
		
		System.out.println(myAccount.name);			// 접근 가능
		System.out.println(myAccount.open);			// 접근 가능
		System.out.println(myAccount.number);		// 접근 가능
		//System.out.println(myAccount.balance);	// 접근 불가
	}
}
