public class Pancake extends SortAlgorithm
{
	/**
	 * Sort array (values)
	 * @return number of nano seconds to run
	 */
	public long sort()
	{
		long start = System.nanoTime();
		for(int i = values.length - 1; i >= 0; i--)
		{
			flip(findMax(i));
			flip(i);
		}
		return System.nanoTime() - start;
	}
	
	/**
	 * Returns the index of the maximum value
	 * @param end the last index to search to
	 * @return the index of the maximum value
	 */
	private int findMax(int end)
	{
		int max = 0;
		for(int i = 0; i <= end; i++)
		{
			if(values[i] > values[max])
			{
				max = i;
			}
		}
		return max;
	}
	
	
	/**
	 * Flip the array from the 0 to end
	 * @param end the last index to flip to
	 */
	private void flip(int end)
	{
		for(int i = 0, j = end; i <= end / 2; i++, j--)
			swap (i, j);
	}
}
