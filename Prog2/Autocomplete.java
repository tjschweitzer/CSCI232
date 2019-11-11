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
        Term[] returnArray = new Term[hi - low + 1];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = The_terms[low + i];
        }
        return returnArray;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term r = new Term(prefix, 0);
        int hi = BinarySearchDeluxe.lastIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        int low = BinarySearchDeluxe.firstIndexOf(The_terms, r, Term.byPrefixOrder(prefix.length()));
        return hi - low + 1;
    }
}