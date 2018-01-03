import java.lang.reflect.Array;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester 
{

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		
		Deck d1 = new Deck (ranks, suits, pointValues);
		
		String[] ranks2 = {"one", "two", "three"};
		String[] suits2 = {"blue", "red", "orange", "green"};
		int[] pointValues2 = {11, 12, 13};
		
		Deck d2 = new Deck (ranks2, suits2, pointValues2);
		
		Deck[] toTest = {d1, d2};
		
		for (int i = 0; i != toTest.length; i++)
		{
			System.out.printf ("Deck #%d\n%s\nisEmpty(): %s\nDealt card: %s\nSize: %s\n\n-----\n", i, toTest[i],
					toTest[i].isEmpty(), toTest[i].deal(), toTest[i].size());
		}
		
		/* Deck tester for activity 4 */
	}
}
