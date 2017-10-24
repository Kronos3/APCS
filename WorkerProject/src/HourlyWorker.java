
public class HourlyWorker extends Worker 
{
	public final double overtimeRate = 1.5;
	
	/**
	 * Constructs a new HourlyWorker from name and salaryRate
	 * @param name The name of the HourlyWorker
	 * @param salaryRate The salaryRate of the HourlyWorker
	 */
	HourlyWorker (String name, double salaryRate)
	{
		super(name, salaryRate);
	}
	
	/**
	 * Computes the pay of the HourlyWorker given number of hours
	 * @param hours Number of hours worked in the week
	 * @return The pay given hours worked in a week
	 */
	public double computePay (int hours)
	{
		int overtime = 0;
		if (hours > weeklyHours)
		{
			overtime += hours - weeklyHours;
			hours -= overtime;
		}
		return (hours * super.getSalaryRate()) 
				+ (overtime * overtimeRate * this.getSalaryRate());
	}
}
