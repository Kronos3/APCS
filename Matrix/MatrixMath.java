public class MatrixMath
{
    
    public static Matrix scalarMultiply (Matrix mat, int k)
    {
        int[][] matArr = mat.getMyNumbers ();
        
        int i;
        for (i = 0; i != matArr.length; i++)
        {
            for (int j = 0; j != matArr[i].length; j++)
            {
                matArr[i][j] *= k;
            }
        }
        
        return matArr;
    }
    
    public static Matrix subtract (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getColumns()
            || mat1.getRows() != mat2.getRows())
        {
            System.err.println ("Cannot find sum");
            return null;
        }
        
        int[][] outArr = new int[mat1.getRows()][mat1.getColumns()];
        for (int row = 0; col != mat1.getRows(); row++)
        {
            for (int col = 0; col != mat1.getColumns(); col++)
            {
                outArr[row][col] = mat1[row][col] - mat2[row][col];
            }
        }
        
        return new Matrix (outArr);
    }
    
    public static Matrix add (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getColumns()
            || mat1.getRows() != mat2.getRows())
        {
            System.err.println ("Cannot find sum");
            return null;
        }
        
        int[][] outArr = new int[mat1.getRows()][mat1.getColumns()];
        for (int row = 0; col != mat1.getRows(); row++)
        {
            for (int col = 0; col != mat1.getColumns(); col++)
            {
                outArr[row][col] = mat1[row][col] + mat2[row][col];
            }
        }
        
        return new Matrix (outArr);
    }
    
    public static Matrix multiply (Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() != mat2.getRows())
        {
            System.err.println ("Cannot find determinant");
            return null;
        }
        
        int[][] outArr = new int[mat1.getRows()][mat2.getColumns()];
        
        for (int row = 0; col != mat1.getRows(); row++)
        {
            for (int col = 0; col != mat2.getColumns(); col++)
            {
                outArr[row][col] = rowMultiply (mat1.getRow (row), mat2.getCol(col));
            }
        }
        
        return new Matrix (outArr);
    }
    
    public static int rowMultiply (int[] row, int[] col)
    {
        int sum = 0;
        for (int i = 0; i != row.length; i++)
            sum += row[i] * col[i];
        return sum;
    }
}

