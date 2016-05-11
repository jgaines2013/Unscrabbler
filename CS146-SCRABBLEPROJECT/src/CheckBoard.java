import java.util.*;

public class CheckBoard
{
    private PriorityQueue<String> heap;
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
                    for(int i = 0; i < pos.i; i++)
                    {
                        if(word.length() < pos.i + 1 || word.charAt(i) == pos.character)
                            heap.add(word);
                    }
                }
            }
        }
        
        word = heap.poll();
    }
    
    /* Currently working on this
    public Board createBoard(Board b, String word)
    {
        word = this.word;
        for(Position pos : q)
        {
            if(word.indexOf(pos.character) > 0)
            {
                
            }
        }
    }
    */
}