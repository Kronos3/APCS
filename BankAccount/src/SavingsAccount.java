/**
 * An account that earns interest at a fixed rate
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minimumBalance;
    
    /**
     * Constructs a bank account with a given interest rate.
     * @param rate the interest rate
     */
    public SavingsAccount(double rate)
    {
        interestRate = rate;
        this.minimumBalance = getBalance();
    }
    
    /**
     * Returns the minimumBalance
     * @return the minimumBalance
     */
    public double getMinimumBalance()
    {
    	return this.minimumBalance;
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
    	super.deposit(amount);
    	if (this.minimumBalance == 0 && this.getBalance() != 0) 
    	{
    		this.minimumBalance = this.getBalance();
    	}
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        super.withdraw(amount);
        if (this.minimumBalance > this.getBalance()) 
        {
        	this.minimumBalance = this.getBalance();
        }
    }
    
    /**
     * Adds the earned interest to the account balance.
     */
    public void endOfMonth()
    {
        double interest = getMinimumBalance() * interestRate / 100;
        deposit(interest);
    }
    
    /**
     * Converts SavingsAccount to String
     */
    public String toString ()
    {
    	return String.format("%sinterestRate: $%.2f\nminimumBalance: $%.2f\n", super.toString(), this.interestRate, this.minimumBalance);
    }
}