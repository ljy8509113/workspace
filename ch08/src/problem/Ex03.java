package problem;

public class Ex03 {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount(-100000);
		try {
			ba.deposit(100000);
			ba.withdraw(100000);
			ba.withdraw(200000);
		}catch(InvalidWithdraw e) {
			e.printStackTrace();
		}
		
	}
	
}
