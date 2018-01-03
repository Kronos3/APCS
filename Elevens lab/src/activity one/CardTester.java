/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card[] cards = {
				new Card ("eight", "clubs", 1),
				new Card ("eight", "clubs", 1),
				new Card ("two", "diamonds", 2),
		};
		
		for (int i = 0; i != cards.length; i++)
		{
			System.out.printf("test%d: %s\n", i + 1, cards[i]);
			System.out.printf("test%d == test%d (%s)\n", i, (i + 1) % cards.length,
					cards[i].matches(cards[(i + 1) % cards.length]));
		}
	}
}
