import java.util.ArrayList;

/**
 * The Message class stores a message.
 */
public class Message
{
	private User sender;
	private ArrayList<User> recipients;
	private String subject;
	private String message;
	private Time timestamp;
	public static int MAX_SMALL_MESSAGE_LEN = 16;
	
	/**
	 * Create a new message given a sender, recipient, subject and message
	 * @param sender the sender of the message
	 * @param recipient the primary recipient
	 * @param subject the subject of the message
	 * @param message the message text
	 * @param CC optional other recipients
	 */
	public Message(User sender, User recipient, String subject, String message, User... CC)
	{
		this.sender = sender;
		this.recipients = new ArrayList<User>();
		this.recipients.add(recipient);
		
		for (int i = 0; i != CC.length; i++)
		{
			this.recipients.add(CC[i]);
		}
		
		this.subject = subject;
		this.message = message;
		this.timestamp = new Time ();
	}
	
	/**
	 * Returns sender, the User who sent the message.
	 * @return sender The User who sent the message.
	 */
	public User getSender()
	{
		return sender;
	}
	
	/**
	 * Returns recipient, the Recipient of the message.
	 * @return recipient The User who the message is sent to.
	 */
	public User getRecipient()
	{
		return this.recipients.get(0);
	}
	
	/**
	 * Returns subject, the subject of the message.
	 * @return subject The subject of the message.
	 */
	public String getSubject()
	{
		return subject;
	}
	
	/**
	 * Returns message, the text of the message.
	 * @return message The text of the message.
	 */
	public String getMessageText()
	{
		return message;
	}
	
	/**
	 * Returns the length of the message.
	 * @return length The length of the message.
	*/
	public int getLength()
	{
		return this.message.length();
	}
	
	/**
	 * Compares the toCompare message to this
	 * @param toCompare the message to compare to
	 * @return 0 if they are equal and 1 if they are not
	 */
	public int compareTo (Message toCompare)
	{
		if (!toCompare.getMessageText().equals(this.getMessageText())
			|| !toCompare.getSubject().equals(this.getSubject()))
		{
			return 1;
		}
		return 0;
	}
	
	/**
	 * Returns a string with the names of the recipients that are CCed
	 * @return a string with the names of the recipients that are CCed
	 */
	public String getCC ()
	{
		String out = new String();
		for (int i = 1; i != this.recipients.size(); i++)
		{
			out += this.recipients.get(i);
			if (i + 1 != this.recipients.size());
				out += ", ";
		}
		return out;
	}
	
	/**
	 * Converts message to its string representation
	 */
	public String toString()
	{
		return String.format("[%s] (%s): %s",
			this.timestamp,
			this.getSubject(),
			this.getMessageText().substring(0, Math.min(MAX_SMALL_MESSAGE_LEN, this.getLength())) 
				+ (this.getLength() <= MAX_SMALL_MESSAGE_LEN ? "" : "...")
			);
	}
}
