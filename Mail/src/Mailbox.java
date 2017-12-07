import java.util.ArrayList;
/**
 * Simulates a mailbox
 */
public class Mailbox
{
    private ArrayList<Message> messages;
    
    /**
     * Creates a new mailbox
     */
    public Mailbox()
    {
        messages = new ArrayList<Message>();
    }
    
    /**
     * Prints out a list of all the messages in this Mailbox
     */
    public void printMessages()
    {
        for(int i = this.messages.size() - 1; i >= 0; i--)
        {
            System.out.println(this.messages.get(i));
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
