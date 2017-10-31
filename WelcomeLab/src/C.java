
public class C extends Message {
	/**
	 * Returns the C function to return "Hello World"
	 * @return the C function to return "Hello World"
	 */
	public String hello_world() {
		return "#include <string.h>\n" + 
				"#include <stdlib.h>\n" + 
				"\n" + 
				"char* get_message ()\n" + 
				"{\n" + 
				"    char* out_str = malloc (strlen(\"Hello World\"));\n" + 
				"    strcpy (out_str, \"Hello World\");\n" + 
				"    return out_str;\n" + 
				"}";
	}
}
