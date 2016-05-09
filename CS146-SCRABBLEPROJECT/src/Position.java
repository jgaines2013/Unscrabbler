
public class Position
{
    int i;
    int j;
    
    /**
     * Creates a data type Position, which holds the column and row values in a 2d array
     * @param i The column index
     * @param j The row index
     */
    public Position(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
    
    public String toString()
    {
        return String.format("Position: %d, %d", i, j);
    }
}
