/**
 * Super class for different Languages
 * @author atuser
 *
 */
public abstract class Message {
	
	/**
	 * Returns Hello World in a language
	 * @return Hello World in a language
	 */
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
