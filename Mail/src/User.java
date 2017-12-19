import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User 
{
	private String address;
	private String name;
	private byte[] passwd;
	
	private Mailbox readMail;
	private Mailbox unreadMail;
	
	/**
	 * Creates a new user with name name, password passwd, and address   emailAddress.
	 * @param name The user's name.
	 * @param passwd The user's password.
	 * @param emailAddress The user's address.
	 */
	User (String name, String passwd, String emailAddress)
	{
		this.name = name;
		this.address = emailAddress;
		this.passwd = hashSHA256 (passwd);
		
		this.readMail = new Mailbox (this);
		this.unreadMail = new Mailbox (this);
	}
	
	/**
	 * Returns true if inPass is equal to passwd and false if it is not.
	 * @return Whether inPass is equal to passwd.
	 */
	public boolean checkPassword (String inPass) 
	{
		return new String(hashSHA256 (inPass)).equals(new String (this.passwd));
	}
	
	/**
	 * Adds an incoming message to to unread mailbox
	 * @param msg the new incoming message
	 */
	public void recieveMessage (Message msg)
	{
		this.unreadMail.addMessage(msg);
	}
	
	/**
	 * Takes a string and outputs the string hashed with SHA256.
	 * @param toHash The string to hash.
	 * @return The hashed string.
	 */
	public byte[] hashSHA256 (String toHash)
	{
		MessageDigest md;
		try 
		{
			md = MessageDigest.getInstance("SHA");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		md.update(toHash.getBytes());
		return md.digest();
	}
	
	/**
	 * Adds msg to the unreadMail Mailbox.
	 * @param msg The message to add to unrealMail.
	 */
	public String getAddress ()
	{
		return this.address;
	}
	
	/**
	 * Returns the name of the User
	 * @return the name of the User
	 */
	public String getName ()
	{
		return this.name;
	}
	
	/**
	 * Returns the read Mailbox of the User
	 * @return the read Mailbox of the User
	 */
	public Mailbox getRead ()
	{
		return this.readMail;
	}
	
	/**
	 * Returns the unread Mailbox of the User
	 * @return the unread Mailbox of the User
	 */
	public Mailbox getUnread ()
	{
		return this.unreadMail;
	}
	
	/**
	 * Returns the string representation of the User
	 * @return the string representation of the User
	 */
	public String toString ()
	{
		return this.getAddress();
	}
}