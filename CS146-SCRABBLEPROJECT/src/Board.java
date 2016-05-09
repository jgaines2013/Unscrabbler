import java.util.*;

public class Board
{
    private char[][] board;
    
    public Board()
    {
        board = new char[15][15];
    }
    
    public Board(char[][] b)
    {
        board = b;
    }
    
    public void add(int i, int j, char c)
    {
        board[i][j] = c;
    }
    
    public Queue<Position> Scan()
    {
        Queue<Position> p = new LinkedList<Position>();
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != 0)
                    p.add(new Position(i,j));
            }
        }
        return p;
    }
    
    public String wordAt(Position start, Position end)
    {
        String word = "";
        for(int i = end.j; i >= 0; i--)
        {
            word += board[start.i][end.j - i];
        }
        return word;
    }
}
