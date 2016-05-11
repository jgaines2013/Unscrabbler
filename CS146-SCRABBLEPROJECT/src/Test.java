import java.util.*;
import java.io.*;
public class Test 
{
    public static void main(String args[]) throws FileNotFoundException 
    {
        Trie test = new Trie(); //Creates an empty trie
        Scanner in = new Scanner(new File("ospd.txt")); //Imports the txt file
        while(in.hasNextLine())
        {
            test.insert(in.nextLine()); //Adds each word in the txt file to the trie
        }
        in.close();
        
        String testWord = "hello";
        Board board = new Board();
        for(int i = 0; i < testWord.length(); i++)
        {
            board.add(i + 8, 4, testWord.charAt(i));
        }
        handTiles hand = new handTiles("acker");
        CheckBoard cb = new CheckBoard();
        //Queue<Position> that = board.Scan();
        cb.check(board, test, hand);
        System.out.println(board);
        System.out.println(cb.heap);
    }
}