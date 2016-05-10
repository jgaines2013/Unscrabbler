
public class TrieNode {
	//master TrieNode
	TrieNode[] arr;
	//signifies 
	boolean isEnd;
	char character;
	TrieNode parent;
	
	public TrieNode()
	{
		this.arr = new TrieNode[26];
	}
	
}
