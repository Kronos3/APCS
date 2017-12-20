
/**
 * Calls functions and passes arguments along to lower level function calls
 * Holds metadata about the arguments required
 */
public class Command 
{
	private String commandName;
	private String[] args;
	private Runnable fcall;
	
	/**
	 * Creates a new command given commandName, fcall, and its arguments
	 * @param commandName the command’s name
	 * @param fcall the point to the command’s function
	 * @param args the command’s infinite arguments
	 */
	public Command (String commandName, Runnable fcall, String... args)
	{
		this.commandName = commandName;
		this.fcall = fcall;
		this.args = args;
	}
	
	/**
	 * Prints what you did wrong when creating command
	 * @param argc the amount of args inputed from the commandline
	 */
	public void printHelp (int argc)
	{
		if (argc != -1)
		{
			System.out.printf("Expected %d arguments got %d\n", this.args.length, argc);
		}
		System.out.printf("Usage: %s ", this.commandName);
		for (int i = 0; i != this.args.length; i++)
		{
			System.out.printf("<%s> ", this.args[i]);
		}
		System.out.println();
	}
	
	/**
	 * Returns the pointer to the command's function call
	 * @return the pointer to the command's function call
	 */
	public Runnable getCall ()
	{
		return fcall;
	}
	
	/**
	 * Returns the count of arguments that this command takes
	 * @return the count of arguments that this command takes
	 */
	public int getArgc ()
	{
		return this.args.length;
	}
	
	/**
	 * Returns the string representation of the command
	 * @return the string representation of the command
	 */
	public String toString ()
	{
		String out = new String();
		out += String.format("%s ", this.commandName);
		for (int i = 0; i != this.args.length; i++)
		{
			out += String.format("<%s> ", this.args[i]);
		}
		return out;
	}
}
