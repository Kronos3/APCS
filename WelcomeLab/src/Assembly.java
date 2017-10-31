
public class Assembly extends Message {
	/**
	 * Returns the Assembly function to that prints "Hello World"
	 * @return the Assembly function to that prints "Hello World"
	 */
	public String hello_world() {
		return "\n" + 
				"        .global _start\n" + 
				"\n" + 
				"        .text\n" + 
				"_start:\n" + 
				"        # write(1, message, 13)\n" + 
				"        mov     $1, %rax\n" + 
				"        mov     $1, %rdi\n" + 
				"        mov     $message, %rsi\n" + 
				"        mov     $13, %rdx\n" + 
				"        syscall\n" + 
				"\n" + 
				"        # exit(0)\n" + 
				"        mov     $60, %rax\n" + 
				"        xor     %rdi, %rdi\n" + 
				"        syscall\n" + 
				"message:\n" + 
				"        .ascii  \"Hello, world\"";
	}

}
