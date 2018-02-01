public class IntArrayWorker {
    /**
     * two dimensional matrix
     */
    private int[][] matrix = null;

    /**
     * set the matrix to the passed one
     *
     * @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix) {
        matrix = theMatrix;
    }

    /**
     * Method to return the total
     *
     * @return the total of the values in the array
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total using a nested for-each loop
     *
     * @return the total of the values in the array
     */
    public int getTotalNested() {
        int total = 0;
        for (int[] rowArray : matrix) {
            for (int item : rowArray) {
                total = total + item;
            }
        }
        return total;
    }

    /**
     * Find the number of occurences of toCount
     * @param toCount to number to look for in the matrix
     * @return the number of occurences of toCount in the matrix
     */
    public int getCount(int toCount)
    {
        int total = 0;
        for (int[] i : this.matrix)
            for (int j : i)
                if (j == toCount)
                    total++;
        return total;
    }

    /**
     * Returns the largest number in the matrix
     * @return the largest number in the matrix
     */
    public int getLargest ()
    {
        int largest = matrix[0][0];
        for (int[] i : matrix)
            for (int j : i)
                if (j > largest)
                    largest = j;
        return largest;
    }

    /**
     * Get the sum of column coln
     * @param coln the column number to sum
     * @return the sum of the column
     */
    public int getColTotal (int coln)
    {
        int total = 0;
        for (int[] i : matrix)
            total += i[coln];
        return total;
    }

    /**
     * Method to fill with an increasing count
     */
    public void fillCount() {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }

    /**
     * print the values in the array in rows and columns
     */
    public void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * fill the array with a pattern
     */
    public void fillPattern1() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length;
                 col++) {
                if (row < col)
                    matrix[row][col] = 1;
                else if (row == col)
                    matrix[row][col] = 2;
                else
                    matrix[row][col] = 3;
            }
        }
    }

}