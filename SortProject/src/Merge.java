public class Merge extends SortAlgorithm {
	/**
	 * Sort array (values)
	 * @return number of nano seconds to run
	 */
	public long sort () {
		long start = System.nanoTime();
		
		temp = new int[values.length];
		mergeSort(0, values.length - 1);
		
		return System.nanoTime() - start;
	}
	
	private int[] temp;
	
	/**
	 * Apply the merge sort algorithm to sort this.values
	 * @param start the starting index
	 * @param end the ending index
	 */
	private void mergeSort (int start, int end) {
		if (start >= end)
			return;
		
		int middle = (start + end) / 2;
		
		mergeSort(start, middle);
		mergeSort(middle + 1, end);
		merge (start, middle, middle + 1, end);
	}
	
	/**
	 * Merge two sub arrays into a larger array
	 * @param l_first the first index on the left side
	 * @param l_last the last index on the left side
	 * @param r_first the first index on the right side
	 * @param r_last the last index on the right side
	 */
	private void merge (int l_first, int l_last, int r_first, int r_last) {
		int save = l_first;
		
		int i;
		for (i = l_first; l_first <= l_last && r_first <= r_last; i++) {
			if (values[l_first] < values[r_first]) {
				temp[i] = values[l_first];
				l_first++;
			}
			else {
				temp[i] = values[r_first];
				r_first++;
			}
		}
		
		for (int k = l_first; k <= l_last; i++, k++)
			temp[i] = values[k];
		for (int k = r_first; k <= r_last; i++, k++)
			temp[k] = values[i];
		for (i = save; i <= r_last; i++)
			values[i] =  temp[i];
	}
}
