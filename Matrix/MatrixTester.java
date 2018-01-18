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
        int[][] tri2d = {
                {0, 0},
                {3, 0},
                {0, 4}
        };
        int[][] tri3d = {
                {0, 0, 3},
                {3, 0, 1},
                {0, 4, 5}
        };
        Matrix test_3x3 = new Matrix (b1);
        Matrix test_7x7 = new Matrix(b2);
        Matrix test_3x4 = new Matrix (b3);
        Matrix triangle_test2d = new Matrix (tri2d);
        Matrix triangle_test3d = new Matrix (tri3d);
        System.out.printf ("Matrix b1: %s"
                + "\n\nMatrix b2: %s"
                + "\n\nMatrix b3: %s"
                + "\n\nMatrix tri2d: %s"
                + "area of tri2d: %s\n"
                + "\n\nMatrix tri3d: %s"
                + "area of tri3d: %s\n"
                + "\n\nscalar multiply 3 * b2: %s"
                + "\n\nb1 + b1: %s"
                + "\n\nb1 - (2 * b1): %s"
                + "\n\nb1 * b3: %s"
                + "\nb1 == b2: %s"
                + "\nb1 == b1: %s\n",
                test_3x3,
                test_7x7,
                test_3x4,
                triangle_test2d,
                MatrixMath.getTriangleArea2d(triangle_test2d),
                triangle_test3d,
                MatrixMath.getTriangleArea3d(triangle_test3d),
                MatrixMath.scalarMultiply(test_7x7, 3),
                MatrixMath.add(test_3x3, test_3x3),
                MatrixMath.subtract(test_3x3, MatrixMath.scalarMultiply(test_3x3, 2)),
                MatrixMath.multiply(test_3x3, test_3x4),
                test_3x3.equals(test_7x7),
                test_3x3.equals(test_3x3)
                );
    }
}
