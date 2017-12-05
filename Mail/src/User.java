import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User 
{
	private String address;
	private String name;
	private byte[] passwd;
	
	private Mailbox readMail;
	private Mailbox unreadMail;
	
	User (String name, String passwd, String emailAddress)
	{
		this.name = name;
		this.address = emailAddress;
		this.passwd = hashSHA256 (passwd);
	}
	
	public boolean checkPassword (String inPass) 
	{
		byte[] toCheck = hashSHA256 (inPass);
		
		if (toCheck == null) 
		{
			return false;
		}
		
		for (int i = 0; i != toCheck.length; i++)
		{
			if (this.passwd[i] != toCheck[i])
			{
				return false;
			}
		}
		return true;
	}
	
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
	
	public String getAddress ()
	{
		return this.address;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public Mailbox getRead ()
	{
		return this.readMail;
	}
	
	public Mailbox getUnread ()
	{
		return this.unreadMail;
	}
}