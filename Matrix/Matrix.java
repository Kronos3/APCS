public class Matrix
{
    private int[][] mat;
    
    /**
     * Construct a new Matrix given a 2d array
     * @param mat the 2d array
     */
    Matrix (int[][] mat)
    {
        this.mat = mat;
    }
    
    /**
     * Get a row of the matrix at index i
     * @param i the index of the row to get
     * @return the row at index i
     */
    public int[] getRow (int i)
    {
        return this.mat[i];
    }
    
    /**
     * Return a clone of the matrix 2d array
     * @return a clone of the matrix 2d array
     */
    public int[][] getMyNumbers ()
    {
        int[][] out = new int[mat.length][mat[0].length];
        for (int i = 0; i != out.length; i++)
            for (int j = 0; j != out[0].length; j++)
                out[i][j] = mat[i][j];
        return out;
    }
    
    /**
     * Returns a column of the matrix at index i
     * @param i the index of the column
     * @return the column at index i of this matrix
     */
    public int[] getColumn (int i)
    {
        return getCol (mat, i);
    }
    
    /**
     * Get an element at a column and row
     * @param row the row of the element
     * @param col the column of the element
     * @return the element at the row and column
     */
    public int getElement (int row, int col)
    {
        return mat[row][col];
    }
    
    /**
     * Get number of rows in the matrix
     * @return the number of rows
     */
    public int getRows ()
    {
        return this.mat.length;
    }
    
    /**
     * Get number of columns in the Matrix
     * @return number of columns
     */
    public int getColumns ()
    {
        return mat[0].length;
    }
    
    /**
     * Get the determinant of the matrix
     * @return the determinant
     */
    public int getDet ()
    {
        return getDet (this.mat);
    }
    
    /**
     * Returns a string repesentation of the matrix and the determinant as well
     * @return a string repesentation of the matrix and the determinant as well
     */
    public String toString ()
    {
        String out = String.format ("Matrix (%d x %d)\n", getRows(), getColumns());
        for (int i = 0; i != this.getRows(); i++)
            for (int j = 0; j != this.getColumns(); j++)
                out +=  (j == 0 ? "| " : "") + this.getElement(i, j) + (j + 1 == this.getColumns() ? "\t|\n" : " ");
        
        out += String.format ("Determinant: %s\n-------------\n", this.getDet());
        return out;
    }
    
    /**
     * Checks if two matrix are equal to each other
     * @param mat the matrix to compare to
     * @return true if they are equal and false if not
     */
    public boolean equals (Matrix mat)
    {
        if (mat.getRows() != getRows() || mat.getColumns() != getColumns())
            return false;
        
        boolean status = true;
        for (int i = 0; i != getRows() && status; i++)
            for (int j = 0; j != getColumns() && status; j++)
                if (mat.getElement(i, j) != getElement(i, j))
                    status = false;
        
        return status;
    }
    
    /**
     * Get the determinant of a 2d array subMat
     * @param subMat the 2d array to recursively find the determinant of
     * @return the determinant of subMat
     */
    private static int getDet (int[][] subMat)
    {
        if (subMat.length != subMat[0].length)
            return 0;
        
        int det = 0;
        
        if (subMat.length != 2)
        {
            int sign = 1;
            
            for (int i = 0; i != subMat[0].length; i++)
            {
                int[][] miniMat = new int[subMat.length - 1][subMat.length - 1];
                
                for (int j = 0, c = 0; j < subMat.length; j++)
                    if (j != i)
                    {
                        miniMat = setCol (miniMat, getSub(getCol(subMat, j),1), c);
                        c++;
                    }
                
                det += sign * getDet (miniMat) * subMat[0][i];
                sign *= -1;
            }
        }
        else
            det = (subMat[0][0] * subMat[1][1]) - (subMat[0][1] * subMat[1][0]);
        
        return det;
    }
    
    /**
     * Returns an sub array of in from start to end
     * @param in the array to create a smaller one from
     * @param start the start index to copy from
     * @param end the end index to copy to. if end is negative it will measure from the end
     * @return the sub array from start to end
     */
    private static int[] getSub (int[] in, int start, int end)
    {
        if (end < 0)
            end = (in.length + end);
        
        int[] out = new int[(end + 1) - start];
        
        for (int i = start; i <= end; i++)
            out[i - start] = in[i];
        
        return out;
    }
    
    /**
     * Get a smaller array from a certain starting index
     * @param in the source index to read from
     * @param start the starting index
     * @return the smaller array from start
     */
    private static int[] getSub (int[] in, int start)
    {
        return getSub (in, start, -1);
    }
    
    /**
     * Set the column of an array to value of another array and return it
     * @param arr the source array
     * @param col the column to copy
     * @param colNum the index of the column to copy to
     * @return the 2d array that was changed
     */
    private static int[][] setCol (int[][] arr, int[] col, int colNum)
    {
        for (int j = 0; j != col.length; j++)
            arr[j][colNum] = col[j];
        
        return arr;
    }
    
    /**
     * Get a column of the given 2d array
     * @param arr the array to read the column from
     * @param col the index of the column to read from
     * @return the column of the given index
     */
    private static int[] getCol (int[][] arr, int col)
    {
        int[] out = new int[arr.length];
        for (int k = 0; k != arr.length; k++)
            out[k] = arr[k][col];
    
        return out;
    }
}
