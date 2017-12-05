import java.util.ArrayList;
/**
 * Simulates a mailbox
 * @author Nicholas.Wight
 * @version 2017.12.05
 */
public class Mailbox
{
    private ArrayList<Message> messages;
    private User parent;
    
    /**
     * Creates a new mailbox
     */
    public Mailbox(User parent)
    {
    	this.parent = parent;
        messages = new ArrayList<Message>();
    }
    
    /**
     * Prints out a list of all the messages in this Mailbox
     */
    public void checkMessages()
    {
        for(int i = 0; i < this.messages.size(); i++)
        {
            //read.add(0,unread.remove(i));
        }
    }
    
    /**
     * Adds a message to the messages
     * @param msg the message to be added
     */
    public void addMessage(Message msg)
    {
        messages.add(msg);
    }
    
    public boolean moveMessage(Mailbox dest, Message msg)
    {
    	for (int i = 0; i != dest.messages.size(); i++)
    	{
    		if (this.messages.get(i).compareTo(msg) == 0)
    		{
    			this.messages.remove(i);
    			dest.addMessage(msg);
    			return true;
    		}
    	}
    	return false;
    }
}
