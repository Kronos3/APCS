import java.math.BigDecimal;

/**
 * Employee with a wage and hourly work
 * @author Andrei Tumbar
 *
 */
public class Paycheck 
{
	private BigDecimal wage;
	private BigDecimal hours;
	private final int OVERTIME_HOURS = 40;
	private final double OVERTIME_WAGE = 1.5;
	
	/**
	 * Creates a new Paycheck with wage and hours
	 * @param wage The new wage on the paycheck
	 * @param hours The hours worked
	 */
	public Paycheck(String wage, String hours)
	{
		this.wage = new BigDecimal(wage);
		this.hours = new BigDecimal(hours);
	}
	
	/**
	 * Returns the wage of paycheck
	 * @return wage of paycheck
	 */
	public BigDecimal getWage()
	{
		return this.wage;
	}
	
	/**
	 * Returns the hours of paycheck
	 * @return hours of paycheck
	 */
	public BigDecimal getHours()
	{
		return this.hours;
	}
	
	/**
	 * Returns the computed pay
	 * @return The computed pay 
	 */
	public BigDecimal getPay()
	{
		BigDecimal totalPay = BigDecimal.ZERO;
		if(this.hours.compareTo(new BigDecimal(OVERTIME_HOURS)) == 1)
		{
			totalPay = totalPay.add(this.hours.subtract(new BigDecimal(this.OVERTIME_HOURS)).multiply(this.wage).multiply(new BigDecimal(OVERTIME_WAGE)));
			totalPay = totalPay.add(new BigDecimal (this.OVERTIME_HOURS).multiply(this.wage));
		}
		else
		{
			totalPay = totalPay.add(this.hours.multiply(this.wage));
		}
		return totalPay;
	}
}
