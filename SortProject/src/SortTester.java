import java.text.DecimalFormat;
import java.util.function.Function;

abstract class SortAlgorithm {
	protected int[] values;
	
	/**
	 * Initializes new SortAl
	 */
	SortAlgorithm () {
		values = null;
	}
	
	/**
	 * Sets this.values to in
	 * @param in the new array to set this.values to
	 */
	public void set (int[] in) {
		this.values = in;
	}
	
	/**
	 * Swaps members of values at indexes i and j
	 * @param i the first index to swap
	 * @param j the second index to swap
	 */
	protected void swap (int i, int j) {
		int buf = values[i];
		values[i] = values[j];
		values[j] = buf;
	}
	
	/**
	 * Returns true of this.values is sorted
	 * @return true of this.values is sorted
	 */
	public boolean isSorted()
	{
		for(int i = 1; i < values.length; i++)
		{
			if(values[i] < values[i - 1])
				return false;
		}
		return true;
	}
	
	/**
	 * Sort array (values)
	 * @return number of nano seconds to run
	 */
	abstract public long sort ();
	
	/**
	 * Name of the class (ie. Merge, Bubble, Pancake)
	 * @return
	 */
	public String getName() {
		return this.getClass().getName();
	}
	
	/**
	 * Returns a string of all of the elements in values
	 * @return a string of all of the elements in values
	 */
	public String toString()
	{
		String out = "";
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		for (int index = 0; index < values.length; index++) {
			value = values[index];
			if (((index + 1) % 10) == 0)
				out += fmt.format(value) + '\n';
			else
				out += fmt.format(value) + " ";
		}
		out += '\n';
		return out;
	}
}

public class SortTester {
	private static int[] array_size = {250, 1000, 5000, 10000, 100000};
	private static int TRIAL_NUMBER = 30;
	
	public static void main (String[] args) {
		
		SortAlgorithm[] algorithms = new SortAlgorithm[3];
		algorithms[0] = new Bubble();
		algorithms[1] = new Merge();
		algorithms[2] = new Pancake();
		
		for (SortAlgorithm al : algorithms) {
			System.out.println(al.getName());
			for (int size : array_size) {
				System.out.println(size);
				for (int i = 0; i < TRIAL_NUMBER; i++) {
					al.set(generate(size));
					long timeTaken = al.sort();
					System.out.printf("%d,%d\n", i + 1, timeTaken);
				}
				System.out.println ();
			}
		}
	}
	
	private static int[] generate (int size) {
		return generate(size, 0, 100);
	}
	
	private static int[] generate (int size, int min, int max) {
		int[] out = new int[size];
		
		for (int i = 0; i < size; i++)
			out[i] = (int)((Math.random() + min) * max);
		
		return out;
	}
}
