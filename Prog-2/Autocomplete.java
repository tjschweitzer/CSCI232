import java.util.Arrays;

public class Autocomplete {
    Term[] The_terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        The_terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            The_terms[i] = terms[i];
        }
        Arrays.sort(The_terms);

    }

    // Returns all terms that start with the given prefix, in descending order of
    // weight.
    public Term[] allMatches(String prefix) {
        // return an empty array if no matches
        Term r = new Term(prefix, 0);
        int hi = BinarySearchDeluxe.lastIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        int low = BinarySearchDeluxe.firstIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        if (hi ==-1 || low == -1) {
            return new Term[0];
        } 
        Term[] returnArray = new Term[hi - low + 1];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = The_terms[low + i];
        }
        Arrays.sort(returnArray, Term.byReverseWeightOrder());
        return returnArray;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term r = new Term(prefix, 0);
        int hi = BinarySearchDeluxe.lastIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        int low = BinarySearchDeluxe.firstIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        return hi - low + 1;
    }
    
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}