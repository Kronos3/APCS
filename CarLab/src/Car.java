/**
 * A car with fuel and fuel efficiency
 * @author andrei.tumbar
 */
public class Car
{
	private double mpg;
	private double fuel;
	private double maxFuel;
	private double totalDistance;
	private double startingValue; // Marvin's idea
	private String name;
	
	/**
	 * Constructs a new Car with a full tank
	 * @param name Name of the car
	 * @param mpg The miles per gallon rating of the car
	 * @param maxFuel The maximum fuel the tank can hold
	 * @param startingValue The value (in dollars) that the car starts at
	 */
	public Car(String name, double mpg, double maxFuel, double startingValue)
	{
		this.mpg = mpg;
		this.maxFuel = maxFuel;
		this.fuel = this.maxFuel;
		this.totalDistance = 0;
		this.name = name;
		this.startingValue = startingValue;
	}
	
	/**
	 * Returns the name of the car
	 * @return Returns the name of the car
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the current fuel to the max fuel
	 */
	public void fillTank()
	{
		this.fuel = this.maxFuel;
	}
	
	/**
	 * Drive the car a certain distance
	 * @param miles The distance in miles
	 */
	public void driveDistance(double miles)
	{
		double maxMiles = this.fuel * this.mpg;
		double milesDriven;
		if (miles >= maxMiles)
		{
			milesDriven = maxMiles;
			this.fuel = 0;
			System.out.println("Your tank is empty!");
		}
		else
		{
			milesDriven = miles;
			this.fuel -= milesDriven / this.mpg;
		}
		
		this.totalDistance += milesDriven;
	}
	
	/**
	 * Returns the value of the car with the current mileage according to a logistic function
	 * @return Returns the value of the car with the current mileage according to a logistic function
	 */
	public double getValue()
	{
		/* Function modeled by
		*  (startingValue * 2) / (1 + e^(x * 0.0002))
		*/
		final double depreciationFactor = 0.0002;
		double outValue = (this.startingValue * 2) / (1 + Math.pow(Math.E, depreciationFactor * this.totalDistance));
		
		return outValue;
	}
	
	/**
	 * Convert this instance into a string
	 */
	public String toString ()
	{
		return String.format("Car Specs:\nName: %s\nTank Size: %s\nMPG: %s\nCurrent Fuel: %s\nMiles Driven: %s\nCurrent Value: %s\n", 
							this.name, this.maxFuel, this.mpg, this.fuel, this.totalDistance, this.getValue ());
	}
}
