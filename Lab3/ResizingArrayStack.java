/******************************************************************************
 *  Compilation:  javac ResizingArrayStack.java
 *  Execution:    java ResizingArrayStack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  
 *  Stack implementation with a resizing array.
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.AbstractList;
import java.util.Arrays;


public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
       // need to do something here
        n=0;
        a = (Item[]) new Object[n]; 
        }

    /**
     * Is this stack empty?
     */
    public boolean isEmpty() {
       // need to do something here //DONE
        return n==0;
    }

    /**
     * Returns the number of items in the stack.
     */
    public int size() {
       // need to do something here // DONE
        return n;
        
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n; // Makes sure the capacity is larger then the current size of the array
        a = Arrays.copyOf(a, capacity);
       // need to do something here //DONE
    }



    /**
     * Adds the item to this stack.
     */
    public void push(Item item) {
       // need to do something here
        if(n>=a.length-1) {
            resize(n*2+1); //needs to have addition in the resize to increase from initial size zero
        }
        a[n]=item; //appends newest item to array
        n++; // increments the size value 
    }

    /**
     * Removes and returns the item most recently added to this stack.
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       // need to do something here
        n--; //decreases size value 
        Item temp =a[n]; // moves value to temp
        a[n] = null; //removes value from array
        return temp;
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /* 
     * OPTIONAL:  An iterator, mostly useful for interrogating the queue 
     * (aka linked list) to see if it's working as expected)
     * It doesn't implement remove() since it's optional
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
           // need to do something here
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
           // need to do something here
            return a.length >1;
        }

        public Item next() {
           // need to do something here
            return a[i];
            
        }
    }

    /**
     * This isn't necessary for the data type, but it is useful to
     * unit test the ResizingArrayStack data type.
     * You don't need to change this code at all.
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
