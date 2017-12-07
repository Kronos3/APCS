
public class Command 
{
	private String commandName;
	private String[] args;
	private Runnable fcall;
	
	public Command (String commandName, Runnable fcall, String... args)
	{
		this.commandName = commandName;
		this.fcall = fcall;
		this.args = args;
	}
	
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
	
	public Runnable getCall ()
	{
		return fcall;
	}
	
	public int getArgc ()
	{
		return this.args.length;
	}
	
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
