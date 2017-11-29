public class FractionTester
{
	public static void main (String[] args)
	{
		Fraction test = new Fraction (2, 3);
		Fraction test2 = new Fraction (6, 9);
		
		System.out.println (test);
		System.out.println (test2);
		System.out.println (test2.reduce ());
		System.out.println (test.compareTo (test2));
		System.out.println (test.compareTo (new Fraction (4, 5)));
	}
}
