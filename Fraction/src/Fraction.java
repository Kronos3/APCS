public class Fraction implements Comparable<Fraction>
{
	public int numerator;
	public int denominator;
	
	/**
	 * Construct a new Fraction given its numerator and denominator
	 * @param numerator the numerator of the new Fraction
	 * @param denominator the denominator of the new Fraction
	 */
	public Fraction (int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Returns the objects denominator
	 * @return the objects denominator
	 */
	public int getDenominator ()
	{
		return denominator;
	}
	
	/**
	 * Returns the objects numerator
	 * @return the objects numerator
	 */
	public int getNumerator ()
	{
		return numerator;
	}
	
	/**
	 * Reduces the Fraction to lowest terms
	 * @return returns a new Fraction in lowest terms
	 */
	public Fraction reduce ()
	{
		int gcf = getGCF (numerator, denominator);
		return new Fraction (numerator / gcf, denominator / gcf);
	}
	
	
	/**
	 * Calculates the GCF given integers a and b
	 * @param a the first int to calculate
	 * @param b the second int to calculate
	 * @return the gcf of a and b
	 */
	public int getGCF (int a, int b)
	{
		if (b == 0) 
		{
			return a;
		}
		else
		{
			return getGCF (b, a % b);
		}
	}
	
	/**
	 * Compares this fraction to the Fraction tocompare
	 * @param tocompare the Fraction to compare this to
	 * @return -1 if tocompare is less, 0 if equal and 1 if greater than
	 */
	public int compareTo (Fraction tocompare)
	{
		int numer_1 = tocompare.getDenominator () * this.getNumerator ();
		int numer_2 = this.getDenominator () * tocompare.getNumerator ();
		
		return new Integer (numer_1).compareTo (new Integer (numer_2));
	}
	
	/**
	 * Returns the decimal of the fraction
	 * @return the decimal of the fraction
	 */
	public double getDecimal ()
	{
		return numerator / (double)denominator;
	}
	
	/**
	 * Returns the string representation of the Fraction
	 * @return the string representation of the Fraction
	 */
	public String toString ()
	{
		return String.format ("%s / %s", numerator, denominator);
	}
}
