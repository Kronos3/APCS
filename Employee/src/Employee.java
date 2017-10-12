/**
 * Employee with a salary that can be changed
 */
public class Employee
{
	private double salary;
	private String name;
	
	/*
	 * Initializes the Employee class
	 * @param employName name of the employee
	 * @param currentSalary salary of employee
	 */
	public Employee(String employeeName, double currentSalary)
	{
		this.name = employeeName;
		this.salary = currentSalary;
	}
	
	/*
	 * Returns the name of the employee
	 * @return name of the employee
	 */
	public String getName()
	{
		return this.name;
	}
	
	/*
	 * Returns the salary of the employee
	 */
	public double getSalary()
	{
		return this.salary;
	}
	
	/*
	 * Raises the salary by Percentage
	 * @param byPercent percent to raise the salary
	 */
	public void raiseSalary(double byPercent)
	{
		this.salary += this.salary * (byPercent / 100);
	}
	
	/*
	 * Converts the employee class to a string
	 * @return String of the employee class
	 */
	public String toString()
	{
		return String.format("Employee: %s\nSalary: %s\n", getName(), getSalary());
	}
}
