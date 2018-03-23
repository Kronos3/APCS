import java.util.Scanner;

public class NumberGuesser {
	private static Scanner sc;
	private static InputChecker yes_no;
	private static InputChecker high_low;
	private static InputChecker guess_choose;
	
	private static class InputChecker {
		String[] self;
		int[] delim;
		
		InputChecker (String[] in, int delim) {
			this.delim = new int[] {delim};
			this.self = in;
		}
		
		InputChecker (String[] in, int[] delim) {
			this.self = in;
			this.delim = delim;
		}
		
		private int input_int (String prompt) {
			int k;
			System.out.print (prompt);
			while ((k = this.checkInput(sc.next())) == -1) {
				System.out.print (prompt);
			}
			
			return k;
		}
		
		private boolean input (String prompt) {
			return input_int(prompt) == 0;
		}
		
		private int checkInput (String inputStr) {
			int i = 0;
			for (int curr_delim = 0; curr_delim <= this.delim.length; curr_delim++) {
				int end_here;
				if (curr_delim == this.delim.length)
					end_here = this.self.length;
				else
					end_here = this.delim[curr_delim];
				for (; i < end_here; i++) {
					if (inputStr.equals(this.self[i]))
						return curr_delim;
				}
			}
			
			
			System.out.printf ("Invalid input '%s'\n", inputStr);
			return -1;
		}
	}
	
	public static void main(String[] args) {
		initInputs ();
		sc = new Scanner(System.in);
		
		boolean keepPlaying = true;
		while (keepPlaying) {
			playGame ();
			keepPlaying = yes_no.input("Play again? (y/n): ");
		}
		
		sc.close ();
	}
	
	private static void initInputs () {
		String[] yn = {"yes", "y", "no", "n"};
		
		String[] hl = {"higher", "h", "lower", "l", "yes", "y"};
		int[] hl_delim = {2, 4};
		
		String[] gc = {"guess", "g", "choose", "c"};
		yes_no = new InputChecker(yn, 2);
		high_low = new InputChecker(hl, hl_delim);
		guess_choose = new InputChecker(gc, 2);
	}
	
	private static void playGame () {
		if (guess_choose.input ("Guess number or choose number? (guess/choose): "))
			computersChoice();
		else
			playersChoice();
	}
	
	private static void playersChoice () {
		System.out.println ("Choose a number from 1 to 100 (inclusive)");
		binarySearch(1, 100, 0);
	}
	
	private static void binarySearch (int low, int high, int try_count) {
		System.out.printf("%d?\n", (low + high) / 2);
		
		int in = high_low.input_int("(lower/higher/yes): ");
		
		if (in != 2 &&
					high - low < 1) {
			System.out.println("Cheater cheater pumpkin eater");
			return;
		}
		
		if (in == 2)
			System.out.printf("Took %d tries\n", try_count + 1);
		else if (in == 0)
			binarySearch(((low + high) / 2) + 1, high,try_count + 1);
		else if (in == 1)
			binarySearch(low, (low + high) / 2 - 1, try_count + 1);
	}
	
	private static void computersChoice () {
		int target = (int)((Math.random() * 100) + 1);
		
		
		int i = 0;
		
		boolean correct = false;
		while (!correct) {
			System.out.print("Guess number: ");
			int temp = sc.nextInt();
			i++;
			
			if (temp < target)
				System.out.println("higher");
			else if (temp > target)
				System.out.println("lower");
			else
				System.out.printf("You got it in %d %s\n", i, i == 1 ? "try" : "tries");
			correct = temp == target;
		}
	}
}
