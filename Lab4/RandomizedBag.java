/******************************************************************************
 *  Compilation:  javac ResizingArrayStack.java
 *  Execution:    java ResizingArrayStack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *  
 *  Stack implementation with a resizing array.
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


public class RandomizedBag<Item> implements Iterable<Item> {
    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    /**esizingArrayStack
     * Initializes an empty stack.
     */
    public RandomizedBag() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * Is this stack empty?
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in the stack.
     */
    public int size() {
        return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;

       // alternative implementation
       // a = java.util.Arrays.copyOf(a, capacity);
    }



    /**
     * Adds the item to this stack.
     */
    public void put(Item item) {
        if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }
    
    public Item get() {
        
        int rand = StdRandom.uniform(n-1);
        Item item=a[rand];
        a[rand]=a[--n];

        

        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    public Item sample() {
            
        return a[StdRandom.uniform(n-1)];
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        private Item[] b;         // array of items

        public ReverseArrayIterator() {
            i = n;
            b = (Item[]) new Object[n];
            for (int j = 0; j < i; j++) {
                b[j]=a[j];
            }
            
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return i > 0;
        }

       
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int rand = StdRandom.uniform(i--);
            Item item=b[rand];
            b[rand]=b[i];
            return item;
        }
    }


    /**
     * Unit tests the {@code Stack} data type.
     */

        public static void main(String[] args) {
        
        
        
        RandomizedBag<String> stack = new RandomizedBag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.put(item);
            else if (!stack.isEmpty()) StdOut.print(stack.get() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}