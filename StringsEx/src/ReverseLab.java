public class ReverseLab 
{
	public static void main(String[] args)
	{
		System.out.println(reverseInteger(new Integer (23510)));
	}
	
	/**
	 * Returns the reverse representation of the given Integer in
	 * @param in the Integer to reverse
	 * @return the reversed Integer
	 */
	public static Integer reverseInteger (Integer in)
	{
		if (in < 0) {
			System.err.println("'in' must be >= 0!");
			return null;
		}
		StringBuilder buffer = new StringBuilder (in.toString());
		buffer.reverse();
		return Integer.parseInt(buffer.toString());
	}
}
