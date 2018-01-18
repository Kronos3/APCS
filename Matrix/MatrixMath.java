import java.util.function.BiFunction;

public class MatrixMath
{
    /**
     * Scalar multiply a Matrix by a scalar
     * @param mat the matrix to multiply
     * @param k the scalar factor to multiply
     * @return the newly 'scaled' matrix
     */
    public static Matrix scalarMultiply (Matrix mat, int k)
    {
        int[][] matArr = mat.getMyNumbers();
        
        for (int i = 0; i != matArr.length; i++)
            for (int j = 0; j != matArr[i].length; j++)
                matArr[i][j] *= k;
        
        return new Matrix (matArr);
    }
    
    /**
     * Subtract to Matrices
     * @param mat1 the first matrix
     * @param mat2 the matrix to substract from the first matrix
     * @return the difference of the matrices
     */
    public static Matrix subtract (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getColumns()
            || mat1.getRows() != mat2.getRows())
        {
            System.err.println ("Cannot find sum");
            return null;
        }
        
        int[][] outArr = mat1.getMyNumbers();
        for (int row = 0; row != mat1.getRows(); row++)
            for (int col = 0; col != mat1.getColumns(); col++)
                outArr[row][col] -= mat2.getElement(row, col);
        
        return new Matrix (outArr);
    }
    
    /**
     * Add to Matrices
     * @param mat1 the first matrix to add
     * @param mat2 the second matrix to add
     * @return the sum of the matrices
     */
    public static Matrix add (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getColumns()
            || mat1.getRows() != mat2.getRows())
        {
            System.err.println ("Cannot find sum");
            return null;
        }
        
        int[][] outArr = mat1.getMyNumbers();
        for (int row = 0; row != mat1.getRows(); row++)
            for (int col = 0; col != mat1.getColumns(); col++)
                outArr[row][col] += mat2.getElement(row, col);
        
        return new Matrix (outArr);
    }
    
    /**
     * Multiply two matrices
     * @param mat1 the first matrix to multiply
     * @param mat2 the second matrix to multiply
     * @return the product of the two matrices
     */
    public static Matrix multiply (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getRows())
        {
            System.err.println ("Cannot find determinant");
            return null;
        }
        
        int[][] outArr = new int[mat1.getRows()][mat2.getColumns()];
        
        for (int row = 0; row != mat1.getRows(); row++)
            for (int col = 0; col != mat2.getColumns(); col++)
                outArr[row][col] = rowMultiply (mat1.getRow (row), mat2.getColumn(col));
        
        return new Matrix (outArr);
    }
    
    /**
     * Get the area of a triangle using Bramagupta's formula
     * @param mat triangle represented given a 2x3 Matrix of 3 points on a 2d plane
     * @return the area of a triangle
     */
    public static double getTriagleArea2d (Matrix mat)
    {
        BiFunction<int[], int[], Double> distance = (p1, p2) -> {
            return Math.sqrt(Math.pow (p2[0] - p1[0], 2) + Math.pow (p2[1] - p1[1], 2));
        };
        
        if (mat.getColumns() != 2 && mat.getRows() != 3)
            return 0;
        
        double a = distance.apply(mat.getRow(0), mat.getRow(1));
        double b = distance.apply(mat.getRow(1), mat.getRow(2));
        double c = distance.apply(mat.getRow(0), mat.getRow(2));
        double s = 0.5 * (a + b + c);
        
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    /**
     * Get the area of a triangle using Bramagupta's formula in 3d dimensions
     * @param mat triangle represented given a 3x3 Matrix of 3 points
     * @return the area of a triangle
     */
    public static double getTriagleArea3d (Matrix mat)
    {
        BiFunction<int[], int[], Double> distance = (p1, p2) -> {
            return Math.sqrt(Math.pow (p2[0] - p1[0], 2) + Math.pow (p2[1] - p1[1], 2) + Math.pow (p2[2] - p1[2], 2));
        };
        
        if (mat.getColumns() != 3 && mat.getRows() != 3)
            return 0;
        
        double a = distance.apply(mat.getRow(0), mat.getRow(1));
        double b = distance.apply(mat.getRow(1), mat.getRow(2));
        double c = distance.apply(mat.getRow(0), mat.getRow(2));
        double s = 0.5 * (a + b + c);
        
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    /**
     * Multiply a row and columns and get sum
     * @param row the row to multiply
     * @param col the column to multiply
     * @return the sum of the products of row and col
     */
    private static int rowMultiply (int[] row, int[] col)
    {
        int sum = 0;
        for (int i = 0; i != row.length; i++)
            sum += row[i] * col[i];
        return sum;
    }
}

