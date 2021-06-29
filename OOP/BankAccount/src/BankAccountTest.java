
public class BankAccountTest {
	
	public static void main(String [] args) {
		
		BankAccount one = new BankAccount();
		BankAccount two = new BankAccount();
		
		one.deposit(100.0, "checking");
		two.deposit(300.0, "savings");
		
		
		one.withdraw(50, "checking");
//		one.withdraw(150, "checking");
		two.withdraw(100, "savings");
		
		
		System.out.println(BankAccount.accounts());
		System.out.println(BankAccount.total());
		
		System.out.println(one.getAccountNumber());
		System.out.println(one.getCheckingBalance());
		System.out.println(two.getSavingsBalance());
	}

}
