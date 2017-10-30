public class BankAccountTester 
{
	public static void main(String[] args) 
	{
		test(new CheckingAccount(12));
		test(new SavingsAccount(3.5));
		test(new TimeDepositAccount(3.5, 3));
	}
	
	public static void test (BankAccount account)
	{
		account.deposit(25);
		account.withdraw(14);
		account.deposit(400);
		account.withdraw(36);
		account.withdraw(56);
		account.endOfMonth();
		System.out.println(account);
	}
}
