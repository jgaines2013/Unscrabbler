import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserInput {
	public static String StarterWord;
	public static String newWord;
	
	public static void main(String args[]) throws FileNotFoundException 
    {
		try{
		Trie test = new Trie(); //Creates an empty trie
        
        //----------dictionary build
        Scanner in = new Scanner(new File("ospd.txt")); //Imports the txt file
        while(in.hasNextLine())
        {
            test.insert(in.nextLine()); //Adds each word in the txt file to the trie
        }
        in.close();
        //-----------word/board building
        
        //public int tilePos;
		
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Scrabble time!! \n");
        System.out.println("Enter a starter word: ");
        String n = reader.nextLine(); // Scans the next token of the input as an string.
        //System.out.println("enter your hand: ");
        //String m = reader.nextLine();
        StarterWord=n;
        //newWord=m;
        System.out.println("Enter the position x:");
        int x =reader.nextInt();
        System.out.println("Enter the position y:");
        int y=reader.nextInt();
        reader.nextLine();
        
        //System.out.println("your x:"+x+" your y:"+y); //makes sure its stored
        
        //System.out.println("Enter (H)orizontal of (V)ertical:");
        Board board = new Board();
        //if((H)) do this vvvv
        for(int i = 0; i < StarterWord.length(); i++)
        {
        	
            board.add(i+x, y, StarterWord.charAt(i));
        }
        //if((V)) do this vvv
        //insert code
        
        System.out.println("enter your hand: ");
        String m = reader.nextLine();
        newWord=m;
        
       //System.out.println(StarterWord);
        //System.out.println("Enter your hand: ");
        //n = reader.nextLine();
        handTiles hand = new handTiles(newWord);
        //hand = n;
        CheckBoard cb = new CheckBoard();
        //System.out.println("works after board");
        cb.check(board, test, hand);
        //System.out.println("still works");
        System.out.println(board);
        System.out.println(cb.heap);
        while(newWord!="stop")
        {
        System.out.println("enter your new hand: (enter 1337 to exit)");
        String l = reader.nextLine();
        newWord=l;
        
        //System.out.println("skips this^^");
        hand = new handTiles(newWord);
        cb.check(board, test, hand);
        System.out.println(board);
        System.out.println(cb.heap);
        }
        System.out.println("Scrabble on fellow scrabbler!");
        reader.close();
    

    }
catch(Exception e)
		{System.err.println("Scramble on scrambler! " );}
    }
}
