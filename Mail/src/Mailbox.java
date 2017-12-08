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
            System.out.println(String.format ("[%d] ", this.messages.size() - (i + 1)) + this.messages.get(i));
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
    
    /**
     * Returns a message from the given number
     * @param number the number in the brackets printed in the printMessages
     * @return a message from the given number
     */
    public Message getMessage (int number)
    {
    	return this.messages.get(this.messages.size () - (number + 1));
    }
    
    /**
     * Moves msg to the dest mailbox
     * @param dest the destination mailbox
     * @param msg the message to move
     * @return true if it was successfully moved and false if it was not found
     */
    public boolean moveMessage(Mailbox dest, Message msg)
    {
    	for (int i = 0; i != dest.messages.size(); i++)
    	{
    		if (this.messages.get(i) == msg)
    		{
    			this.messages.remove(i);
    			dest.addMessage(msg);
    			return true;
    		}
    	}
    	return false;
    }
}
