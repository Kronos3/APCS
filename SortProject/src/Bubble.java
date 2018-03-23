public class Bubble extends SortAlgorithm{
	/**
	 * Sort array (values)
	 * @return number of nano seconds to run
	 */
	public long sort () {
		long start = System.nanoTime();
		
		for (int i = 0; i < values.length - 1; i++)
			if (!bubbleUp(i, values.length - 1))
				return System.nanoTime() - start;
		
		return System.nanoTime() - start;
	}
	
	/**
	 * Bubbles up the smallest term to the front of the array
	 * @param startIndex the start of the unsorted partition
	 * @param endIndex the end of the unsorted partition
	 * @return true if a swap was made, false if not
	 */
	private boolean bubbleUp (int startIndex, int endIndex) {
		boolean madeSwap = false;
		for (int i = endIndex; i >= startIndex + 1; i--) {
			if (values[i - 1] > values[i]) {
				madeSwap = true;
				swap(i, i - 1);
			}
		}
		
		return madeSwap;
	}
}
