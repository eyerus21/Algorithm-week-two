import java.util.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Deque<Item> implements Iterable<Item> {


    private Node first;
    private Node last;
    private int size;
    
    public Deque() {
        size = 0;
        first = null;
       last = null;
    }

      private class Node
   {
       Item item;
       Node next;
       Node prev;

		public Node(Item item, Node next, Node prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
   }


    //  

  // return the number of items on the deque
    public int size(){
        return size;
       }
    // is the deque empty?
    public boolean isEmpty(){
     return size==0;
        }

  
 
  // add the item to the front
    public void addFirst(Item item){

     if (item == null) throw new NullPointerException(); 
       Node temp = first;
        first.item = item;
       first.next = temp;
       first.prev = null;
       if (isEmpty()) last = first;
       else temp.prev = first;
       size++;
 }

    // add the item to the back
    public void addLast(Item item){ 
     if (item == null) throw new java.lang.NullPointerException();
       Node temp= last;
       last.item = item;
       last.next = null;
       last.prev = temp;
       if (isEmpty()) first = last;
       else temp.next = last;
       size++;

   }

    // remove and return the item from the front
    public Item removeFirst(){

        if (isEmpty()) throw new java.util.NoSuchElementException();
       Item item = first.item;  
       first = first.next;
       size--;
       if (isEmpty()) last = first;
       else first.prev = null;
       return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
         if (isEmpty()) throw new java.util.NoSuchElementException(); 
       Item item = last.item;
       last = last.prev;
       size--;
       if (isEmpty()) first = last;
       else last.next = null;
       return item;
    }

public Iterator<Item> iterator() {
		return new ListIterator();
	}

    // return an iterator over items in order from front to back
    private class  ListIterator implements Iterator<Item>{
         private Node temp = first;
       
       public boolean hasNext() { return temp != null; }
       public void remove() { throw new java.lang.UnsupportedOperationException(); }
       public Item next()
       {
           if (!hasNext()) throw new java.util.NoSuchElementException();
           Item item = temp.item;
           temp = temp.next;
           return item;
       }
    }

 public static void main(String[] args) { ; }    
}
