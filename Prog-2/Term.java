import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        this.query = query;
        this.weight = weight;

    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                if (v.weight > w.weight) {
                    return -1;
                } else if (v.weight < w.weight) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

    }

    // Compares the two terms in lexicographic order but using only the first r
    // characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                if (r > v.query.length() && r <= w.query.length()) {
                    return v.query.compareTo(w.query.substring(0, r));
                } else if (r <= v.query.length() && r > w.query.length()) {
                    return v.query.substring(0, r).compareTo(w.query);
                } else if (r > v.query.length() && r > w.query.length()) {
                    return v.query.compareTo(w.query);
                } else
                    return v.query.substring(0, r).compareTo(w.query.substring(0, r));

            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        String w = Long.toString(weight);
        return w + '\t' + query;
    }

    // unit testing (you should have some Unit Testing here to confirm that your
    // methods work)
    public static void main(String[] args) {

    }
}
