import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (key == null) throw new NullPointerException("Search key can't be null");
        int lowVal = 0; //sets low to start of the array
        int highVal = a.length - 1; // sets high to start of array
        int middleVal; // initiates the middle value to be calculated at the start of each loop

        if (comparator.compare(key,a[0])==0) {
            return 0;
        }
        
        while (highVal>= lowVal ) {
            middleVal = lowVal + ((highVal-lowVal )/2);
            if (comparator.compare(key, a[middleVal])<0 ) { 
                //value is not in the top half of range
                highVal=middleVal-1;
            }else if (comparator.compare(key, a[middleVal])>0) { 
                // value is not in bottom half of range
                lowVal=middleVal+1;
            }else if(comparator.compare(key, a[middleVal-1])==0) {
                //checks one left of 'middle' to see if it still equals key
                highVal=middleVal-1;
            }else {
                return middleVal;
            }
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        
        if (key==null) {
            throw new NullPointerException("Search key can't be null");
        }
        
        int lowVal = 0; //sets low to start of the array
        int highVal = a.length - 1; // sets high to start of array
        int middleVal; // initiates the middle value to be calculated at the start of each loop

        if (comparator.compare(key,a[highVal])==0) {
            return highVal;
        }
        while (highVal>= lowVal ) {
            middleVal = lowVal + ((highVal-lowVal )/2); //calculates middle value between low and high
            if (comparator.compare(key, a[middleVal])<0 ) { 
                //value is not in the top half of range
                highVal=middleVal-1;
            }else if (comparator.compare(key, a[middleVal])>0) { 
                // value is not in bottom half of range
                lowVal=middleVal+1;
            }else  if (comparator.compare(key, a[middleVal+1])==0) {
                //checks one right of 'middle' to see if it still equals key if so continues to binary search with high half
                lowVal=middleVal+1;
            }else {
                return middleVal;
            }        
        }
        return -1;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work)
    public static void main(String[] args)   {
         }
    
}