
public class Matrix 
{
    int[][] mat;
    
    Matrix (int[][] mat)
    {
        this.mat = new int[mat.length][mat[0].length];
    }
    
    public int[] getRow (int i)
    {
        return this.mat[i];
    }
    
    public int[][] getMyNumbers ()
    {
        return mat;
    }
    
    public int[] getColumn (int i)
    {
        int[] out = new int[mat.length];
        for (int k; k != mat.length; k++)
        {
            out[k] = mat[k][i];
        }
        
        return out;
    }
    
    public int getElement (int row, int col)
    {
        return mat[row][col];
    }
    
    public int getRows ()
    {
        return this.mat.length;
    }
    
    public int getColumns ()
    {
        return mat[0].length;
    }
    
    public int getDet ()
    
    public int getDet (int[][] subMat)
    {
        if (mat.length != 2) {
            int sign = 1;
            
            int rowSelect = 0xff;
            for (int i = 0; i != subMat[0].length; i++)
            {
                i ^= 1 << i;
                int[][] miniMat = new int[subMat.length - 1][subMat[0].length - 1];
                
                for (int j = 0, c = 0; i != subMat[0].length; j++)
                {
                    if (((1 << j) & i) != 0)
                    {
                        miniMat[c] = getColumn(j);
                        c++;
                    }
                }
            }
        }
        
        
    }
    
    private static int[] getSub (int[] in, int start, int end)
    {
        if (end < 0)
            end = (in.length + end);
        
        int[] out = new int[(end + 1) - start];
        
        for (int i = start; i <= end; i++)
            out[i - start] = in[i];
        
        return out;
    }
    
    private static int[] getSub (int[] in, int start)
    {
        getSub (in, start, -1);
    }
}
