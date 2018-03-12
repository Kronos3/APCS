import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
    public static final int SIZE = 7;          // Size of array to be sorted
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
        for (int index = 0; index < SIZE; index++) {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    public static void merge (int l_first, int l_last, int r_first, int r_last) {
        int[] temp = new int [values.length];
        int save = l_first;
    
        int i;
        for (i = l_first; l_first <= l_last
                && r_first <= r_last; i++) {
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
    
    public static void mergeSort (int start, int end) {
        if (start >= end)
            return;
        
        int middle = (start + end) / 2;
        
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        merge (start, middle, middle + 1, end);
    }
    
    public static int split (int low, int high) {
        int small_index = low - 1;
        int pivot = values[high];
        
        for (int j = low; j < high; j++) {
            if (values[j] <= pivot) {
                small_index++;
                swap (j, small_index);
            }
        }
        
        swap (small_index + 1, high);
        return (small_index + 1);
    }
    
    public static void quickSort (int low, int high) {
        if (low < high) {
            int pivot = split (low, high);
            
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }
    
    public static void main(String[] args) throws IOException
    // Tests the other methods of the Sorts class
    {
        initValues();
        printValues();
        
        selectionSort();
        System.out.println("values is sorted (selection): " + isSorted());
        
        initValues();
        insertSort();
        System.out.println("values is sorted (insertion): " + isSorted());
    
    
        initValues();
        mergeSort(0, SIZE - 1);
        System.out.println("values is sorted (merge): " + isSorted());
        
        initValues();
        printValues();
        quickSort(0, SIZE - 1);
        System.out.println("values is sorted (quick): " + isSorted());
        printValues();
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
        
        while (moreToSearch && !finished
                && current >= startIndex + 1) {
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