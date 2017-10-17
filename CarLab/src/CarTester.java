import java.util.Scanner;
import java.util.ArrayList;

/**
 * Tests the car class
 * @author andrei.tumbar
 *
 */
public class CarTester 
{
	private static ArrayList<Car> garage;
	private static int selected;
	
	public static void main(String[] args)
	{
		garage = new ArrayList<Car>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("use 'help' for more commands");
		
		String command = "";
		garage.add(new Car("generic", 21.0, 42.0, 2500));
		selected = 0;
		
		while (!command.equals("exit"))
		{
			System.out.print("> ");
			command = sc.nextLine();
			String[] arguments = command.split("\\s+"); // Split on every whitespace
			try
			{
				if (arguments[0].equals("help"))
				{
					printHelp();
				}
				else if (arguments[0].equals("list"))
				{
					printGarage();
				}
				else if (arguments[0].equals("select"))
				{
					if (findCar(arguments[1]) != -1)
					{
						selected = findCar(arguments[1]);
					}
				}
				else if (arguments[0].equals("drive"))
				{
					garage.get(selected).driveDistance(Double.parseDouble(arguments[1]));
				}
				else if (arguments[0].equals("info"))
				{
					int selectedCar = findCar(arguments[1]);
					if (selectedCar != -1)
					{
						System.out.println(garage.get(selectedCar));
					}
				}
				else if (arguments[0].equals("create"))
				{
					String name = arguments[1];
					double mpg = Double.parseDouble(arguments[2]);
					double maxFuel = Double.parseDouble(arguments[3]);
					double startingValue = Double.parseDouble(arguments[4]);
					garage.add(new Car(name, mpg, maxFuel, startingValue));
				}
				else if (arguments[0].equals("refuel"))
				{
					garage.get(selected).fillTank();
				}
				else if (arguments[0].equals("exit")); // Let the while condition break
				else
				{
					System.out.println("command not found\nUse 'help' to look at commands");
				}
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Invalid number of arguments!");
			}
			catch (NumberFormatException e)
			{
				System.out.println("Could not convert specified string to double!");
			}
		}
		sc.close();
	}
	
	/**
	 * Prints the help page 
	 */
	public static void printHelp()
	{
		System.out.println("Car Tester CLI");
		System.out.println("Usage:");
		System.out.println("help : print this help page");
		System.out.println("list : prints a list of all the cars in your garage");
		System.out.println("select [name] : 'get in' the car specified");
		System.out.println("drive [miles] : drive a certain number of miles in the selected car");
		System.out.println("info [name] : prints info about the specified car");
		System.out.println("create [name] [mpg] [tankSize] [value] : Create a new car");
		System.out.println("refuel : Refuels the selected car");
		System.out.println("exit : exits the program");
	}
	
	/**
	 * Prints all of the names of the cars in the 'garage'
	 */
	public static void printGarage()
	{
		System.out.println("Cars in your garage:");
		for (int i = 0; i != garage.size(); i++)
		{
			System.out.print(garage.get(i).getName());
			if (i == selected)
			{
				// This car is currently selected
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	
	/**
	 * Returns the index of the car with name
	 * @param name The name to search for
	 * @return The index of the car with name
	 */
	public static int findCar(String name)
	{
		for (int i = 0; i != garage.size(); i++)
		{
			if (garage.get(i).getName().equals(name))
			{
				return i;
			}
		}
		System.out.println("Could not find car specified!");
		return -1;
	}
}
