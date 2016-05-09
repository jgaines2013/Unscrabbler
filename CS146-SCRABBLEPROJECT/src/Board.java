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
    
    /**
     * Adds a character to the board at a certain position
     * @param i The column of the character
     * @param j The row of the character
     */
    public void add(int i, int j, char c)
    {
        board[i][j] = c;
    }
    
    /**
     * @return A Queue holding the positions of all characters currently on the board
     */
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
    
    /**
     * Returns the character at a specific position
     * @param p The position of the character
     * @return The character
     */
    public char characterAt(Position p)
    {
        return board[p.i][p.j];
    }
    
    /**
     * Returns a word when given the start and end index on the board
     * @param start The position of the start of the word
     * @param end The position of the end of the word
     * @return All characters in between and including both positions
     */
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
