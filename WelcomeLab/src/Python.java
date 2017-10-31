
public class Python extends Message {
	/**
	 * Returns the Python function to return "Hello World"
	 * @return the Python function to return "Hello World"
	 */
	public String hello_world() {
		String tab = "    ";
		return "def get_message ():\n"
				+ tab + "return \"Hello World\"";
	}
}
