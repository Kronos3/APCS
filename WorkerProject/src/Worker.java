
public class Worker 
{
	private String name;
	private double salaryRate;
	public final int weeklyHours = 40;
	
	/**
	 * Constructs a new Worker with name and salaryRate
	 * @param name Name of the Worker
	 * @param salaryRate Pay rate of the new Worker
	 */
	Worker (String name, double salaryRate)
	{
		this.name = name;
		this.salaryRate = salaryRate;
	}
	
	/**
	 * Returns the name of the Worker
	 * @return The name of the Worker
	 */
	public String getName ()
	{
		return this.name;
	}
	
	/**
	 * Returns the salaryRate of the Worker
	 * @return The salaryRate of the Worker
	 */
	public double getSalaryRate ()
	{
		return this.salaryRate;
	}
	
	/**
	 * Returns the pay based on the number of hours
	 * @param hours The number of hours worked
	 * @return The pay for number of hours
	*/
	public double computePay (int hours) {
		return hours * getSalaryRate();
	}
	
	/**
	 * Creates a string from the Worker instances
	 * @return String created from the Worker instance
	 */
	public String toString ()
	{
		return String.format("%s (%s):\nsalaryRate: $%.2f per hour", 
				getName(), 
				this.getClass().getSimpleName(), 
				getSalaryRate());
	}
}
