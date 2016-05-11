import java.util.*;

public class Board
{
    private char[][] board;
    
    public Board()
    {
        board = new char[15][15];
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 15; j++)
                board[i][j] = '.';
        }
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
     * Adds a word, given an anchor
     * @param anchor
     * @param word
     */
    public void addWord(Position anchor, String word)
    {
    	char charAnchor = anchor.character;
    	int anchorIndex = 0;
    	
    	for (int x = 0; x < word.length(); x++)
    	{
    		if (word.charAt(x) == charAnchor) {anchorIndex = x; break;} 
    		//everything from 0 to anchorIndex is the left side of the word
    	}
    	
    	//if the anchor is part of a vertical word, build horizontal
    	if ((board[anchor.i][anchor.j-1] == '.') && (board[anchor.i][anchor.j+1] == '.'))
    	{
    	//build left
    	int anchorJ = anchor.j-1;
    	for ( int n = anchorIndex-1; n >= 0; n--)
    	{
    		char buildCharLeft = word.charAt(n);
    		System.out.println("buildCharLeft is " + buildCharLeft);
    		this.add(anchor.i, anchorJ, buildCharLeft);
    		anchorJ--;
    	}
    	//build right
    	anchorJ= anchor.j+1;
    	for (int m = anchorIndex + 1; m < word.length(); m++)
    	{
    		char buildCharRight = word.charAt(m);
    		this.add(anchor.i, anchorJ, buildCharRight);
    		anchorJ++;
    	}
    	}
    	else //build vertically
    	{
    		//build up
    		int anchorI = anchor.i-1;
    		for (int a = anchorIndex-1; a >= 0; a--)
    		{
    			char buildCharUp = word.charAt(a);
    			this.add(anchorI, anchor.j - 1, buildCharUp);
    			anchorI--;
    		}
    		//build down
    		anchorI = anchor.i + 1;
    		for (int b = anchorIndex + 1; b < word.length(); b++)
    		{ 
    			char buildCharDown = word.charAt(b);
    			this.add(anchorI, anchor.j - 1, buildCharDown);
    			anchorI++;
    		}
    	}
    } 	
    
    /**
     * Checks if a position contains anything.
     * @param pos The position you want to check
     * @return true if pos contains a character, false if otherwise.
     */
    public boolean contains(Position pos)
    {
    	if (pos.character != 0)
    	{return true;}
    	return false;
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
                   if(board[i+1][j] == 0 && board[i-1][j] == 0)
                	   	p.add(new Position(i,j,board[i][j]));
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

    public String toString()
        {
            String words = "";
            for (int i = 0; i < board.length; i++)
            {
                for(int j = 0; j < board[0].length; j++)
                {
                    words += String.format(" %s ", board[i][j]);
                }
                words += "\n";
            }
            return words;
        }
}
