/**
 * 
 */

/**
 * @author Andrei Tumbar
 *
 */
public class sep14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println (sep14.oddSum(10));
	}
	
	/**
	 * 
	 */
	public static int oddSum (int n)
	{
		int i = 0;
		int sum = 0;
		while (i <= n)
		{
			if (i % 2 == 1)
			{
				sum += i;
			}
			i++;
		}
		return sum;
	}

}
