import java.util.Arrays;


public class handTilesTester {
	public static void main(String[] args)
	{
		//NOTE: SCRABBLE MAX HAND SIZE IS 7
		String hand = "abcdef";
		char[] testArray = hand.toCharArray();
		handTiles handtile = new handTiles(hand);
		System.out.println(Arrays.toString(testArray));
		//handtile.getAllWords('t');
	}
}
