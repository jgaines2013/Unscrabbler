import java.util.*;

public class CheckBoard
{
     PriorityQueue<String> heap;
    private Queue<Position> q;
    String word;

    public void check(Board b, Trie t, handTiles h)
    {
        heap = new PriorityQueue<String>(new StringComp());
        q = b.Scan();
        for(Position pos : q)
        {
            ArrayList<String> words = h.getAllWords(pos);
            for(String word : words)
            {
                if(t.search(word))
                {
                    for(int i = 0; i <= pos.j; i++)
                    {
                        if(word.length() <= pos.j + 1 || word.charAt(i) == pos.character)
                            heap.add(word);
                    }
                }
            }
        }
        
        word = heap.poll();
        
        Position anchor = q.peek();
        for(Position pos : q)
        {
            for(int i = 0; i < word.length(); i++)
                if(word.charAt(i) == pos.character)
                    anchor = pos;
        }
        b.addWord(anchor, word);
        
    }
    
    /*
    public Board createBoard(Board b, String word)
    {
        b.addWord(anchor, word);
    }
    */
    
}