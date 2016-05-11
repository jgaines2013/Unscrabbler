import java.util.*;

public class handTiles {

	//to hold hand tiles
	char[] hand;
	char[] temp;
	ArrayList<String> listOfPerm = new ArrayList<String>();
	ArrayList<Character> printThis = new ArrayList<Character>();
	public handTiles(String tilesInHand)
	{
		hand = tilesInHand.toCharArray();
		//used to temporarily hold/check tiles
		temp = new char[hand.length + 1];
	}
	
	//anchor is	 a letter on a board. 
	//this method returns all anagrams of the letters.
	//note: CHANGE PARAMETER TO POSITION
	public ArrayList<String> getAllWords(Position anchor)
	{
		String allUsableLetters = Character.toString(anchor.character);
		allUsableLetters += new String(hand);
		
		//needs permutations with length 1,2,3...8
		for (int x = 1; x < allUsableLetters.length(); x++)
		{
		String permLetters = allUsableLetters.substring(0,x);
		permutation(permLetters);
		}
		
		/*
		for (String s: listOfPerm)
		{System.out.println(s);} 
		
		System.out.println("Num of Permutations: " + listOfPerm.size());
		*/
		
		return listOfPerm;
	}
	
	private void permutation2(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) 
	    	{
	    	//System.out.println(prefix);
	    	listOfPerm.add(prefix);
	    	}
	    else {
	        for (int i = 0; i < n; i++)
	            permutation2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public void permutation(String str) { 
	    permutation2("", str); 
	}
	
	

}
