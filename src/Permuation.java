public class Permuation {
    
    public static void main (String[] args)
    {
        for (int i = 0; i != 10; i++)
        {
            printArray (doPermuation());
        }
    }
    
    public static int[] doPermuation ()
    {
        int[] start = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int i = start.length-1; i >= 0; i--)
        {
            int random = (int) (Math.random() * (i + 1));
    
            int buffer = start[random];
            start[random] = start[i];
            start[i] = buffer;
        }
        
        return start;
    }
    
    public static void printArray (int[] arr)
    {
        for (int i : arr)
        {
            System.out.printf ("%d, ", i);
        }
        
        System.out.println();
    }
}
