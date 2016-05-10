
public class Trie {
	private TrieNode root;
	
	public Trie()
	{ root = new TrieNode(); }
	
	public void insert(String word)
	{
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			//c is the nth number of the alphabet
			//goes into respective index of array
			int index = c - 'a'; 
			if (p.arr[index] == null)
			{
				TrieNode temp = new TrieNode();
				temp.character = c;
				temp.parent = p;
				//branches off again.
				p.arr[index] = temp;
				p = temp;
			}
			else
			{ p=p.arr[index]; }
		}
		p.isEnd=true;
	}
	
	public TrieNode searchNode(String word)
	{
	    word = word.toLowerCase();
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			int index = c - 'a';
			if (p.arr[index] != null)
			{
				p = p.arr[index];
			} 
			else 
			{
				return null;
			}
		}
		
		if (p==root)
		{return null;}
		
		return p;
	}
	
	public boolean startsWith(String prefix)
	{
		TrieNode p = searchNode(prefix);
		if (p==null)
		{return false;}
		return true;
	}
	
	public boolean search(String word)
	{
		TrieNode p = searchNode(word);
		if (p==null)
		{return false;}

		if (p.isEnd)
		{return true;}
		
		return false;
	}
	
	
	
	public String printTrie(TrieNode n)
	{
	    if(n.parent == null)
	        return "" + n.character;
	    else
	        return printTrie(n.parent) + n.character;
	}
}




