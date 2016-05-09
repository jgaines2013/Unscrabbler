
public class Position
{
    int i;
    int j;
    
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
