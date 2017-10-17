/**
 * Employee with a wage and hourly work
 * @author Andrei Tumbar
 *
 */
public class Paycheck 
{
	private double wage;
	private double hours;
	private final int overtimeHours = 40;
	private final double overtimeWage = 1.5;
	
	/**
	 * Creates a new Paycheck with wage and hours
	 * @param wage The new wage on the paycheck
	 * @param hours The hours worked
	 */
	public Paycheck(double wage, double hours)
	{
		this.wage = wage;
		this.hours = hours;
	}
	
	/**
	 * Returns the wage of paycheck
	 * @return wage of paycheck
	 */
	public double getWage()
	{
		return this.wage;
	}
	
	/**
	 * Returns the hours of paycheck
	 * @return hours of paycheck
	 */
	public double getHours()
	{
		return this.hours;
	}
	
	/**
	 * Returns the computed pay
	 * @return The computed pay 
	 */
	public double getPay()
	{
		double totalPay = 0;
		if(this.hours > 40)
		{
			totalPay += (this.hours - this.overtimeHours) * (this.wage * overtimeWage);
			totalPay += this.overtimeHours * this.wage;
		}
		else
		{
			totalPay += this.hours * this.wage;
		}
		return totalPay;
	}
}
