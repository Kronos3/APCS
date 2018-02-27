public class RecursionTest {
    public static void main (String[] args) {
        System.out.println (gcd (24, 40));
        System.out.println (nth_term(2, 5, 6));
        System.out.println (power (2, 5));
        System.out.println (sine (Math.PI / 2, 5));
    }
    
    public static int power (int base, int expo) {
        if (expo == 0)
            return 1;
        return base * power (base, expo - 1);
    }
    
    public static int nth_term (int a, int d, int n) {
        if (n == 1)
            return a;
        return d + nth_term(a, d, n - 1);
    }
    
    public static int gcd (int n, int m) {
        if (m % n == 0)
            return n;
        return gcd (m % n, n);
    }
    
    public static double sine (double x, int n) {
        if (n == 1)
            return x;
        double factorial = 1;
        for (int i = (2 * n) - 1; i > 1; i--)
            factorial *= i;
        return sine (x, n - 1) + Math.pow (-1, n - 1) * (Math.pow (x, 2 * n - 1)
                / factorial);
        
    }
}
