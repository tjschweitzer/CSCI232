public class Outcast {

    WordNet myWordNet;

    public Outcast(WordNet wordnet) // constructor takes a WordNet object
    {
        myWordNet = wordnet;
    }

    public String outcast(String[] nouns) // given an array of WordNet nouns, return an outcast
    {
        Integer minimumInteger = 0;
        Integer tempInteger;
        String outcast = nouns[0];
        for (int i = 0; i < nouns.length; i++) {
            tempInteger = 0;
            for (int j = 0; j < nouns.length; j++) {
                tempInteger = tempInteger + myWordNet.distance(nouns[i], nouns[j]);
            }
            if (tempInteger > minimumInteger) {
                outcast = nouns[i];
                minimumInteger = tempInteger;
            }
        }

        return outcast;

    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}