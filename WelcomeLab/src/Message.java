/**
 * Super class for different Languages
 * @author atuser
 *
 */
public abstract class Message {
	public abstract String hello_world();
	
	/**
	 * Returns the hello world function of this language
	 * @return the hello world function of this language
	 */
	public String toString()
	{
		return String.format("Langauge: %s\n%s\n-----\n", this.getClass().getSimpleName(), this.hello_world());
	}
}
