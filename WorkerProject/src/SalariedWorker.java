
public class SalariedWorker extends Worker
{
	/**
	 * Constructs a new SalariedWorker from name and salaryRate
	 * @param name The name of the SalariedWorker
	 * @param salaryRate The salaryRate of the SalariedWorker
	 */
	SalariedWorker (String name, double salaryRate)
	{
		super(name, salaryRate);
	}
	
	/**
	 * Computes the pay of the SalariedWorker for a 40 hours week
	 * @param hours Number of hours worked in the week (not used)
	 * @return The pay for one weeks work
	 */
	public double computePay (int hours)
	{
		return getSalaryRate () * weeklyHours;
	}
}
