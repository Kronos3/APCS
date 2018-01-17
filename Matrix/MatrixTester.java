public class MatrixTester
{
    public static void main (String[] args)
    {
        int[][] b1 = {
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        };
        int[][] b2 = {
                {4, 5, 8, 3, 6, 7, 8},
                {3, 6, 4, 8, 4, 3, 4},
                {1, 1, 9, 0, 1, 3, 6},
                {3, 5, 1, 2, 2, 7, 8},
                {0, 1, 0, 4, 5, 8, 4},
                {4, 7, 5, 6, 7, 8, 2},
                {3, 5, 1, 2, 1, 7, 8}
        };
        int[][] b3 = {
                {4, 2, 2, 7},
                {4, 31, 2, 5},
                {31, 7, 6, 2}
        };
        int[][] tri = {
                {0, 0},
                {3, 0},
                {0, 4}
        };
        Matrix test_3x3 = new Matrix (b1);
        Matrix test_7x7 = new Matrix(b2);
        Matrix test_3x4 = new Matrix (b3);
        Matrix triangle_test = new Matrix (tri);
        System.out.printf ("Matrix b1: %s"
                + "\n\nMatrix b2: %s"
                + "\n\nMatrix b3: %s"
                + "\n\nMatrix tri: %s"
                + "area of tri: %s\n"
                + "\n\nscalar mutiply 3 * b2: %s"
                + "\n\nb1 + b1: %s"
                + "\n\nb1 - (2 * b1): %s"
                + "\n\nb1 * b3: %s",
                test_3x3,
                test_7x7,
                test_3x4,
                triangle_test,
                MatrixMath.getTriagleArea(triangle_test),
                MatrixMath.scalarMultiply(test_7x7, 3),
                MatrixMath.add(test_3x3, test_3x3),
                MatrixMath.subtract(test_3x3, MatrixMath.scalarMultiply(test_3x3, 2)),
                MatrixMath.multiply(test_3x3, test_3x4)
                );
    }
}
