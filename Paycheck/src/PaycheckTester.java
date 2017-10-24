import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Tests the Employee class
 * @author Andrei Tumbar
 */
public class PaycheckTester
{
	public static final String outFilePath = "outfile.txt";
	public static PrintWriter outFile;
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		outFile = new PrintWriter(outFilePath);
		
		Scanner sc = new Scanner(System.in);
		println("Enter quit to exit.");
		
		String wageStr = "";
		
		while (!wageStr.equals("quit"))
		{
			print("Wage: ");
			wageStr = getInput(sc);
			
			if (!wageStr.equals("quit"))
			{
				print("Hours: ");
				String hourStr = getInput(sc);
				
				Paycheck p = new Paycheck(wageStr, hourStr);
				println(String.format("Paycheck: $%.2f", p.getPay().doubleValue()));
			}
		}
		
		sc.close();
		outFile.close();
	}
	
	/**
	 * Prints the data to file and console
	 * @param data Data to print to console and file
	 */
	public static <T> void print(T data)
	{
		System.out.print(data);
		outFile.print(data);
	}

	/**
	 * Prints the data to file and console with a new line
	 * @param data Data to print to console and file with a new line
	 */
	public static <T> void println(T data)
	{
		System.out.println(data);
		outFile.println(data);
	}
	
	/**
	 * Returns a String read from console (allows to write to file)
	 * @param sc Scanner to read from
	 * @return String read from the console
	 */
	public static String getInput(Scanner sc)
	{
		String out = sc.next();
		outFile.println(out);
		return out;
	}
}
