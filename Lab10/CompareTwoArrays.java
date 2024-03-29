import java.util.HashMap;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.MinPQ;


public class CompareTwoArrays
{
  

    private static boolean compareWithHeap (In inA, In inB, int size) {
        
        
        MinPQ<Integer> aHeap = new MinPQ<Integer>(size*2+1);
        MinPQ<Integer> bHeap = new MinPQ<Integer>(size*2+1);
        
        
        while (!inA.isEmpty()) {
            int item = inA.readInt();
            aHeap.insert(item);
        } 
        while (!inB.isEmpty()) {
            int item = inB.readInt();
            bHeap.insert(item);
        }
        
        for (int i = 0; i < size; i++) {
            if (aHeap.delMin()!=bHeap.delMin()) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean compareWithHash (In inA, In inB, int size) {

        LinearProbingHashST<Integer, Integer> aHashMap = new LinearProbingHashST<Integer, Integer>();
        
        while (!inA.isEmpty()) {
            int item = inA.readInt();
            if(aHashMap.contains(item)) {
                aHashMap.put(item, aHashMap.get(item)+1);
            }else {
                aHashMap.put(item, 1);          
            }
        } 
        
        
        while (!inB.isEmpty()) {
            int item = inB.readInt();
            
            if (aHashMap.get(item)!=0) {
                aHashMap.put(item, aHashMap.get(item)-1);
            }else {
                return false;
            }
            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        if (args.length < 3) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        String filenameA = args[0];
        String filenameB = args[1];
        String method    = args[2];
        
        if ( !method.equals("heap") && !method.equals("hash") ) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        
        In inA = new In(filenameA);
        int nA = inA.readInt();

        In inB = new In(filenameB);
        int nB = inB.readInt();

        if (nA != nB) {
            StdOut.println("Arrays are not the same size, so not equivalent");
            System.exit(0);
        }
        
        boolean match = false;
        
        StopwatchCPU sw = new StopwatchCPU();
        if (method.equals("heap")) {
            match = compareWithHeap(inA, inB, nA);
        } else {
            match = compareWithHash(inA, inB, nA);
        }
        
        
        double elapsed = sw.elapsedTime();
        
        
        StdOut.println("The two input arrays do " + (match?"":"not ") + "match" );
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

