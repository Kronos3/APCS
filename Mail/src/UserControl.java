import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPasswordField;

/**
 * Controls the users and allows for logging in/out
 * @author samuel.catterall
 * @version 12/5/17
 */
public class UserControl
{
	public static Map<String, User> users;
	public static String[] argumentStack;
	public static Map<String, Command> commands;
	public static User loggedIn;
	public static int MAX_PASSWORD_TRIES;
	
	public static void main (String[] args)
	{
		loggedIn = null;
		commands = new HashMap<String, Command> ();
		users = new HashMap<String, User> ();
		
		newCommand ("addUser",
				() -> users.put (argumentStack[0], new User (argumentStack[0], argumentStack[1], argumentStack[2])),
				"name", "password", "address");
		newCommand ("exit",
				() -> System.exit(0));
		newCommand ("login",
				() -> login (argumentStack[0]),
				"username");
		newCommand ("logout",
				() -> loggedIn = null);
		newCommand ("")
	}
	
	public static void handleCommand (String... args)
	{
		Command target = commands.get(args[0]);
		if (target == null)
		{
			System.out.println("Command '%s' not found");
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
	
	public static boolean login (String name)
	{
		User target;
		if ((target = users.get("name")) == null)
		{
			System.out.printf ("User '%s' not found.\n", name);
			return false;
		}
		
		JPasswordField passField = new JPasswordField();
		int tries = 0;
		while (!target.checkPassword(new String (passField.getPassword())) && tries < MAX_PASSWORD_TRIES) 
		{
			System.out.println("Invalid password!");
			tries++;
		}
		
		loggedIn = target;
		
		return true;
	}
	
	public static void newCommand (String name, Runnable call, String... args)
	{
		commands.put (name, new Command (name, call, args));
	}
}
