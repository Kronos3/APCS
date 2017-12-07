import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Controls the users and allows for logging in/out
 */
public class UserControl
{
	public static Map<String, User> users;
	public static String[] argumentStack;
	public static Map<String, Command> commands;
	public static ArrayList<String> commandList;
	public static User loggedIn;
	public static int MAX_PASSWORD_TRIES = 3;
	public static boolean loopStop;
	
	public static void main (String[] args)
	{
		loggedIn = null;
		commands = new HashMap<String, Command> ();
		users = new HashMap<String, User> ();
		commandList = new ArrayList<String>();
		loopStop = false;
		
		newCommand ("addUser",
				() -> users.put (argumentStack[2], new User (argumentStack[0], argumentStack[1], argumentStack[2])),
				"name", "password", "address");
		newCommand ("exit",
				() -> loopStop = true);
		newCommand ("q",
				() -> loopStop = true);
		newCommand ("login",
				() -> login (argumentStack[0]),
				"address");
		newCommand ("logout",
				() -> loggedIn = null);
		newCommand ("mailbox",
				() -> printMailbox (argumentStack[0]),
				"mailbox to read");
		newCommand ("help", () -> printHelp());
		
		Scanner s = new Scanner(System.in);
		while (!loopStop)
		{
			System.out.print("> ");
			handleCommand (s.nextLine().split(" "));
		}
		s.close ();
	}
	
	public static int getMailboxType (String str)
	{
		if (str.equals("unread"))
		{
			return 1 << 0;
		}
		else if (str.equals("read"))
		{
			return 1 << 1;
		}
		return 0 << 0;
	}
	
	public static void printMailbox (String toRead)
	{
		if (!checkLoggedIn())
		{
			return;
		}
		
		Mailbox target = null;
		int mailboxType = getMailboxType (toRead);
		if (mailboxType == 0)
		{
			System.out.printf ("Mailbox '%s' not found!\n", toRead);
			return;
		}
		else if (mailboxType == 1)
		{
			target = loggedIn.getUnread();
		}
		else if (mailboxType == 2)
		{
			target = loggedIn.getRead();
		}
		
		target.printMessages();
	}
	
	public static void handleCommand (String... args)
	{
		Command target = commands.get(args[0]);
		if (target == null)
		{
			System.out.printf("Command '%s' not found\n", args[0]);
			return;
		}
		
		argumentStack = Arrays.copyOfRange (args, 1, args.length);
		if (argumentStack.length != target.getArgc())
		{
			target.printHelp(argumentStack.length);
			return;
		}
		
		target.getCall().run();
		Arrays.fill(argumentStack, null);
	}
	
	public static boolean login (String address)
	{
		User target;
		if ((target = users.get(address)) == null)
		{
			System.out.printf ("User '%s' not found.\n", address);
			return false;
		}
		
		int tries = 0;
		Console cons = System.console();
		if (System.console() == null) {
			System.err.println("Please run in a console!");
			System.exit (1);
		}
		while (!target.checkPassword(new String (cons.readPassword("[%s] ", "Password:"))) 
				&& tries < MAX_PASSWORD_TRIES) 
		{
			System.out.println("Invalid password!");
			tries++;
		}
		
		if (tries == MAX_PASSWORD_TRIES)
		{
			return false;
		}
		
		loggedIn = target;
		
		return true;
	}
	
	public static boolean checkLoggedIn ()
	{
		if (loggedIn == null)
		{
			System.out.println("User not logged in!");
			return false;
		}
		return true;
	}
	
	public static void newCommand (String name, Runnable call, String... args)
	{
		commands.put (name, new Command (name, call, args));
		commandList.add(name);
	}
	
	public static void printHelp ()
	{
		System.out.printf("Current user: %s\n", loggedIn);
		System.out.print("Mail commands:\n");
		for (int i = 0; i != commandList.size(); i++)
		{
			System.out.println(commands.get(commandList.get(i)));
		}
	}
}
