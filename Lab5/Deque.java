/******************************************************************************
 *  Compilation:  javac LinkedQueue.java
 *  Execution:    java LinkedQueue < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt  
 *
 *  A generic queue, implemented using a singly-linked list.
 *
 *  % java Queue < tobe.txt 
 *  to be or not to be (2 left on queue)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
//        private final String theCatGoes ="Meow";
        private Node next;
        private Node previous;
    } 

    /**
     * Initializes an empty queue.
     */
    public Deque() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Is this queue empty?
     */
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Returns the number of items in this queue.
     */
    public int size() {
        return n;     
    }


    /**
     * Adds the item to first spot in queue.
     */
    public void addFirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = null;
        first.previous=null;
        if (isEmpty()) last=first;
        else          
            {oldfirst.next = first;
            first.previous=oldfirst;}
            n++;
    }
    
    /**
     * Adds the item to last spot in queue.
     */
    public void addLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.previous=null;
        last.next=null;
        if (isEmpty())   first=last;
        else           
        {
            oldlast.previous = last;

            last.next = oldlast;
        }
    
        n++;
    }

    /**
     * Removes and returns the first  item on this queue that was least recently added.
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        
         if (size()==1){
             first =null;
             last=null;
         }else {
             first=first.previous;
             first.next=null;             
         }
        
        n--;
        return item;
    }
    
    /**
     * Removes and returns the first  item on this queue that was least recently added.
     */
    public Item removeLast() {
         if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = last.item;
            
             if (size()==1){
                 first =null;
                 last=null;
             }else {
                 last=last.next;
                 last.previous=null;             
             }
            
            n--;
            return item;
        
    }
    

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public void remove()      { throw new UnsupportedOperationException();  }
        
        public boolean hasNext()  { 
            return current != null;                     
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * Unit tests the LinkedQueue data type.
     */
    public static void main(String[] args) {
    
    
    }
}