import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {
     private int size;
    private Item[] s;

    // construct an empty randomized queue
    public RandomizedQueue(){
        size = 0;
        s = (Item[]) new Object[2];
}

    // is the randomized queue empty?
    public boolean isEmpty()
     { 
        return size == 0;
         }

    // return the number of items on the randomized queue
    public int size()
      { 
        return size; 
    }



    // add the item
    public void enqueue(Item item){
        if(item==null) throw new NullPointerException(); 
        if (size == s.length)
            resize(2 * s.length); 
       s[size++]=item;

    }
// Move queue to a new array of given capacity
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = s[i];
        s = copy;
    }
    // remove and return a random item
    public Item dequeue(){
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        // int index = (int)(StdRandom.random() * size);
        int index = StdRandom.uniform(size);
        Item item =  s[index];
      s[index] = s[size - 1];
        s[size - 1] = null; // Avoid loitering
        size--;
        if (size > 0 && size == s.length / 4)  // resize the capacity
            resize(s.length / 2); 
        return item;

    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        int index = StdRandom.uniform(size);
        return s[index];


    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
       return new  RandomizedQueueIterator();
        } 
         private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int i = size;
        private int[] order;
        
        public RandomizedQueueIterator()
        {
            order = new int[i];
            for (int j = 0; j < i; ++j) {
                order[j] = j;
            }
            StdRandom.shuffle(order);
        }
        
        public boolean hasNext() { return i > 0; }
        public void remove() { throw new java.lang.UnsupportedOperationException(); }
        public Item next() 
        { 
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return s[order[--i]]; 
        }
    }
public static void main(String[])
{;}

}