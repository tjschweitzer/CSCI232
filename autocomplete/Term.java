import java.util.Comparator;



public class Term implements Comparable<Term> {

    
    private String query;
    private long weight;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if(query==null) {
            throw new NullPointerException("Entry shouldn't be NULL but who am I to tell you what to do");
        }
        if( weight<0) {
            throw new java.lang.IllegalArgumentException(" Weight needs to be more than zero we aint in space");
        }
        this.query=query;
        this.weight=weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
        return (v,w)->{
                if (v.weight>w.weight) return -1;  
                if (v.weight<w.weight) return 1;
                return 0;  
        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
        if (r<0) {
            throw new java.lang.IllegalArgumentException("Number of items should be more than zero, but here we are....");
        }
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                String smallVString=v.query;
                String smallWString=w.query;
                if (v.query.length()>r) {
                    smallVString = smallVString.substring(0,r);
                }
                if (w.query.length()>r) {
                    smallWString = smallWString.substring(0,r);
                }
                return smallVString.compareTo(smallWString);
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return this.weight+"\t"+ this.query;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work)
    public static void main(String[] args)   {
    }
}