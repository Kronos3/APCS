import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
    public static final int SIZE = 50;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        Random rand = new Random(560);
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        boolean sorted = true;
        for (int i = 0; i < values.length - 1; i++)
            if (values[i] > values[i + 1])
                sorted = false;
        return sorted;
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    public static void printValues()
    // Prints all the values integers
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++) {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException
    // Tests the other methods of the Sorts class
    {
        initValues();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
        
        swap(0, 1);
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
        
        selectionSort();
        System.out.println("values is sorted (selection): " + isSorted());
    
        insertSort();
        System.out.println("values is sorted (insertion): " + isSorted());
    }
    
    /**
     * Returns index holding the smallest value
     * @param startIndex the index to start looking at
     * @param endIndex the last index to check
     * @return the index with the smallest value
     */
    public static int minIndex (int startIndex, int endIndex) {
        int small = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++)
            if (values[i] < values[small])
                small = i;
        return small;
    }
    
    /**
     * Use selection sorting algortithm to sort values
     */
    public static void selectionSort () {
        int current = 0;
        while (current < values.length) {
            int min_i = minIndex(current, values.length - 1);
            swap (current, min_i);
            current++;
        }
    }
    
    /**
     * Use insertion sorting algortithm to sort values
     */
    public static void insertSort () {
        for (int count = 1; count < values.length; count++)
            insertItem(0, count);
    }
    
    /**
     * Insert item at endIndex into correct place between startIndex and endIndex
     * @param startIndex the left bound of the array
     * @param endIndex the item to sort
     */
    public static void insertItem (int startIndex, int endIndex) {
        boolean finished = false;
        boolean moreToSearch = true;
        int current = endIndex;
        
        while (moreToSearch && !finished) {
            if (values[current] < values[current - 1]) {
                swap (current, current - 1);
                current--;
                moreToSearch = current >= startIndex;
            }
            else
                finished = true;
        }
    }
}