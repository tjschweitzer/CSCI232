import java.util.HashMap;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class ShortestCommonAncestor {
    Digraph myDigraph;
    boolean[] marked;

    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        myDigraph = G;
        marked = new boolean[G.V()];

    }

    // length of shortest ancestral path between v and w

    public int scaCalc(int v, int w, boolean returnBool) {

        Integer minInteger = Integer.MAX_VALUE; // Tracks the minimum distance to the sca
        Integer minAncestor = null; // Tacks the sca
        Integer currentInteger = 1; // Distance from starting Node

        Stack<Integer> myStack = new Stack<Integer>(); // Stack used to track BFS
        Stack<Integer> wasMarked = new Stack<Integer>(); // Tracks what nodes have been marked so they can be reverted
                                                         // back

        HashMap<Integer, Integer> vHashMap = new HashMap<Integer, Integer>(); // Key=node-id value=distance from v
        HashMap<Integer, Integer> wHashMap = new HashMap<Integer, Integer>();// Key=node-id value=distance from w

        myStack.push(v);
        vHashMap.put(v, 0); // distance from v to v = 0

        // loops until stack is empty
        while (myStack.size() != 0) {
            Integer sizeInteger = myStack.size();
            // StdOut.println("My V stack: "+myStack+" Size of "+sizeInteger);
            for (int i = 0; i < sizeInteger; i++) {
                Integer temp = myStack.pop();
                Iterable<Integer> tempBag = myDigraph.adj(temp);
                marked[temp] = true;
                wasMarked.push(temp);
                for (Integer integer : tempBag) {
                    if (!marked[integer])
                        myStack.push(integer);
                    vHashMap.put(integer, currentInteger);
                }
            }
            currentInteger = currentInteger + 1;
        }
        currentInteger = 1;

        myStack.push(w);
        wHashMap.put(w, 0);

        while (myStack.size() != 0) {
            Integer sizeInteger = myStack.size();
            // StdOut.println("My W stack: "+myStack+" Size of "+sizeInteger);
            for (int i = 0; i < sizeInteger; i++) {
                Integer temp = myStack.pop();
                Iterable<Integer> tempBag = myDigraph.adj(temp);

                marked[temp] = true;
                for (Integer integer : tempBag) {
                    if (!marked[integer]) {
                        myStack.push(integer);
                    }
                    wHashMap.put(integer, currentInteger);
                }
                wasMarked.push(temp);
            }
            currentInteger = currentInteger + 1;
        }

        for (Integer integer : vHashMap.keySet()) {
            if (wHashMap.containsKey(integer)) {
                if (wHashMap.get(integer) + vHashMap.get(integer) < minInteger) {
                    minInteger = wHashMap.get(integer) + vHashMap.get(integer);
                    minAncestor = integer;
                }
            }
        }

        for (Integer integer : wasMarked) {
            marked[integer] = false;
        }

        if (returnBool) {
            return minAncestor;
        }
        return minInteger;

    }

    public int length(int v, int w) {
        return scaCalc(v, w, false);
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {

        return scaCalc(v, w, true);

    }

    // length of shortest ancestral path of vertex subsets A and B
    public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {

        Integer calcInteger = Integer.MAX_VALUE;
        Integer tempInteger;
        for (Integer integer : subsetA) {
            for (Integer integer2 : subsetB) {
                tempInteger = scaCalc(integer, integer2, false);
                if (tempInteger < calcInteger) {
                    calcInteger = tempInteger;
                }
            }
        }
        return calcInteger;
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        Integer calcInteger = Integer.MAX_VALUE;
        Integer tempInteger;
        for (Integer integer : subsetA) {
            for (Integer integer2 : subsetB) {
                tempInteger = scaCalc(integer, integer2, false);
                if (tempInteger < calcInteger) {
                    calcInteger = tempInteger;
                }
            }
        }
        return calcInteger;
    }

    public static void main(String[] args) {
        In in = new In("digraph1.txt");

        Digraph G = new Digraph(12);
        Integer numInteger = 11;
        for (int i = 0; i < numInteger; i++) {
            String[] tempStrings = in.readLine().split(",");
            Integer v = Integer.parseInt(tempStrings[0]);
            Integer w = Integer.parseInt(tempStrings[1]);
            // G.addEdge(w,v);
            G.addEdge(v, w);
        }

        ShortestCommonAncestor sca = new ShortestCommonAncestor(G);

        StdOut.println(G);

        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sca.length(v, w);
            int ancestor = sca.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}
