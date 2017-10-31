/**
 * An account you keep money in for a certain number of months
 */

public class TimeDepositAccount extends SavingsAccount
{
	private int months;
	public final double WITHDRAW_PENALTY = 3.5;
	
	/**
	 * Constructs a new TimeDepositAccount given rate and mounts
	 * @param rate the interest rate on the account
	 * @param months the months until maturity
	 */
	TimeDepositAccount(double rate, int months)
	{
		super(rate);
		this.months = months;
	}
	
	/**
	 * Returns the months until account maturity
	 * @return the months until account maturity
	 */
	public int getMonths()
	{
		return this.months;
	}
	
	/**
     * Adds the earned interest to the account balance.
     */
    public void endOfMonth()
    {
        super.endOfMonth();
        this.months--;
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
    	if(getMonths() > 0) 
    	{
    		super.withdraw(this.WITHDRAW_PENALTY);
    	}
        super.withdraw(amount);
    }
    
    /**
     * Converts TimeDepositAccount to String
     */
    public String toString ()
    {
    	return String.format("%smonths: %s\n", super.toString(), this.months);
    }
}
