public class Subset{
    public static void main (String[] args) {
        int myNumbah;
        myNumbah= Integer.parseInt(args[0]); // Finds total number of args to print out
        RandomizedBag<String> bag = new RandomizedBag<String>();
        while(!StdIn.isEmpty()) {
            String line = StdIn.readString(); // Reads piped in strings
            bag.put(line); // puts strings in bag
        }
        if (myNumbah>bag.size()) { // checks if number of printed args will be larger then size of bag
            throw new java.lang.IndexOutOfBoundsException("input is lager then array size");
        } else {
            for (int i = 0; i < myNumbah; i++) {
                StdOut.println(bag.get()); // pulls objects out of bag
            }
        }
    }
}