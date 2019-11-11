import java.util.Arrays;

public class Autocomplete {
    private Term[] myTerms;
    
    
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) throw new NullPointerException("Terms can't be null");
        myTerms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            myTerms[i] = terms[i]; 
        }
        Arrays.sort(myTerms);
    }
    

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {//return an empty array if no matches
        if (prefix == null) throw new NullPointerException("Prefix can't be null");
        Term tempTerm = new Term(prefix, 0);
        int tempLength =prefix.length();
        int firstIndex = BinarySearchDeluxe.firstIndexOf(myTerms, tempTerm, Term.byPrefixOrder(tempLength));
        if (firstIndex == -1) return new Term[0]; // returns empty set
        int lastIndex  = BinarySearchDeluxe.lastIndexOf (myTerms, tempTerm, Term.byPrefixOrder(tempLength));
        Term[] myNewTerms = new Term[lastIndex -firstIndex+1];

        for (int i = 0; i <= lastIndex-firstIndex; i++) //creates new array of terms
            myNewTerms[i] = myTerms[firstIndex+i];

        Arrays.sort(myNewTerms, Term.byReverseWeightOrder()); // sorts terms
        return myNewTerms;
    }
    
    
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) throw new NullPointerException("Prefix can't be null");
        
        Term tempTerm = new Term(prefix, 0);
        int tempLength =prefix.length(); 
        int firstIndex = BinarySearchDeluxe.firstIndexOf(myTerms, tempTerm, Term.byPrefixOrder(tempLength));
        int lastIndex = BinarySearchDeluxe.lastIndexOf (myTerms, tempTerm, Term.byPrefixOrder(tempLength));
        
        return lastIndex-firstIndex+1;
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
            System.out.println(terms[i]);
        }


        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);


        String prefix = "my";
        Term[] results = autocomplete.allMatches(prefix);
        for (int i = 0; i < Math.min(k, results.length); i++)
            StdOut.println(results[i]);
        }
    
    
}