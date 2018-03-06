import java.text.DecimalFormat;
import java.util.Random;

public class FractionBubbleTumbar {
    private static Fraction[] values;
    private static int SIZE = 30;
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        boolean sorted = true;
        for (int i = 0; i < values.length - 1; i++)
            if (values[i].compareTo(values[i + 1]) > 0)
                sorted = false;
        return sorted;
    }
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        values = new Fraction[SIZE];
        Random rand = new Random(560);
        System.out.println(rand);
        for (int index = 0; index < SIZE; index++)
            values[index] = new Fraction (
                    Math.abs(rand.nextInt()) % 100,
                    Math.abs(rand.nextInt()) % 100);
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        Fraction temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    public static void printValues()
    // Prints all the values integers
    {
        Fraction value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++) {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(value);
            else
                System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void bubbleSort () {
        for (int i = 0; i < values.length - 1; i++)
            bubbleUp(0, i);
    }
    
    public static void bubbleUp (int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex + 1; i--) {
            if (values[i].compareTo(values[i - 1]) < 0)
                swap (i, i - 1);
        }
    }
    
    public static void main (String[] args) {
        initValues ();
        printValues();
        bubbleSort();
        printValues();
        System.out.println(isSorted());
    }
}

class Fraction implements Comparable<Fraction>
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
        
        return numer_1 - numer_2;
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
        return String.format ("%s/%s", numerator, denominator);
    }
}