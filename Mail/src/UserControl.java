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
	public static Scanner s;
	
	public static void main (String[] args)
	{
		loggedIn = null;
		commands = new HashMap<String, Command> ();
		users = new HashMap<String, User> ();
		commandList = new ArrayList<String>();
		loopStop = false;
		initCommands ();
		s = new Scanner(System.in);
		users.put ("deppe@apcs", new User ("Mr.Deppe", "password", "deppe@apcs"));
		
		
		while (!loopStop)
		{
			System.out.print("> ");
			handleCommand (s.nextLine().split(" "));
		}
		s.close ();
	}
	
	public static void initCommands ()
	{
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
		newCommand ("message",
				() -> sendMessage (argumentStack),
				"recipients...");
		newCommand ("read",
				() -> readMessage (argumentStack[0], argumentStack[1]),
				"mailbox to read from", "message number");
	}
	
	/**
	 * Read a message given the mailbox name and the message number
	 * @param mailbox the name of the mailbox
	 * @param number the message number
	 */
	public static void readMessage (String mailbox, String number) 
	{
		if (!checkLoggedIn())
			return;
		
		Mailbox mailboxPtr;
		if ((mailboxPtr = getMailbox (mailbox)) == null)
			return;
		
		Message target = mailboxPtr.getMessage(Integer.parseInt(number));
		System.out.printf("From: %s\nTo: %s\nCC: %s\nSubject: %s\n\n%s\n", 
				target.getSender(),
				target.getRecipient(),
				target.getCC(),
				target.getSubject(),
				target.getMessageText());
	}
	
	/**
	 * Sends a message to the specified recipient addresses
	 * @param recipients a list of the recipients
	 */
	public static void sendMessage (String... recipients)
	{
		if (loggedIn == null)
		{
			System.out.println("You need to be logged to send a message!");
			return;
		}
		
		User[] userRecip = verifyUsers (recipients);
		if (userRecip.length != 0 && userRecip[0] == null)
		{
			return;
		}
		User mainRecip = users.get(recipients[0]);
		
		System.out.print("Subject: ");
		String subject = s.nextLine();
		
		System.out.print("Message: ");
		String message = s.nextLine(); 
		
		for (int i = 0; i != recipients.length; i++)
		{
			users.get(recipients[i]).recieveMessage(
					new Message (loggedIn, mainRecip, subject, message, userRecip));
		}
	}
	
	/**
	 * Verify that all the users in the UserList exist and return a list of them
	 * @param userList a list of addresses to verify
	 * @return an array of users that correspond to the userList
	 */
	public static User[] verifyUsers (String[] userList)
	{
		User[] out = new User[userList.length - 1];
		for (int i = 0; i != userList.length; i++)
		{
			User target = users.get(userList[i]);
			if (target == null)
			{
				System.out.printf("Address '%s' was not found!\n", userList[i]);
				out[0] = null;
				return out;
			}
			if (i != 0)
			{
				out[i - 1] = target;
			}
		}
		return out;
	}
	
	/**
	 * Returns a pointer to the target mailbox given str
	 * @param str "read" or "unread"
	 * @return the pointer to the mailbox or null if not found
	 */
	public static Mailbox getMailbox (String str)
	{
		if (str.equals("unread"))
			return loggedIn.getUnread();
		else if (str.equals("read"))
			return loggedIn.getRead();
		System.out.printf ("Mailbox '%s' not found!\n", str);
		return null;
	}
	
	/**
	* Prints the contents of the specified mailbox to read
	* @param the mailbox to read
	*/
	public static void printMailbox (String toRead)
	{
		if (!checkLoggedIn())
			return;
		
		Mailbox target;
		if ((target = getMailBox))
		
		
		target.printMessages();
	}

	/**
	* Handles user input and running commands
	* @param args the user input
	*/
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

	/**
	* Logs in to a user with a specified mail address and handles password attempts,
	* returns whether a user was logged into
	* @param the user’s mail address
	* @return the user’s login status
	*/
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
			return false;
		
		loggedIn = target;
		
		return true;
	}
	
	/**
	 * Check if the user is logged
	 * @return true if the user is logged in and false not logged in
	 */
	public static boolean checkLoggedIn ()
	{
		if (loggedIn == null)
		{
			System.out.println("User not logged in!");
			return false;
		}
		return true;
	}
	
	/**
	* Adds a new command to the list of available commands
	* @param name the command’s name
	* @param call the command’s call for execution
	* @param args the command’s arguments 
	*/
	public static void newCommand (String name, Runnable call, String... args)
	{
		commands.put (name, new Command (name, call, args));
		commandList.add(name);
	}
	
	/**
	* Prints the current user and a list of the available commands
	*/
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
