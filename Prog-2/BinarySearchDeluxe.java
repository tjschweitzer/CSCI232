import java.util.Collections;
import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1
    // if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int hi = a.length - 1;
        int low = 0;
        int mid = hi / 2;
        if (comparator.compare(key, a[0]) == 0) {
            return 0;
        }
        while (hi >= low) {
            mid = low + ((hi - low) / 2);
            if (comparator.compare(key, a[mid]) < 0) { // first part of list
                hi = mid - 1;
            } else if (comparator.compare(key, a[mid]) > 0) { // last part of list
                low = mid + 1;
            } else if (comparator.compare(key, a[mid - 1]) == 0) { // mid matches but not done
                hi = mid - 1;

            } else {
                return mid;
            }
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if
    // no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int hi = a.length - 1;
        int low = 0;
        int mid = hi / 2;
        if (comparator.compare(key, a[hi]) == 0) {
            return hi;
        }
        while (hi >= low) {
            mid = low + ((hi - low) / 2);
            if (comparator.compare(key, a[mid]) < 0) { // first part of list
                hi = mid - 1;
            } else if (comparator.compare(key, a[mid]) > 0) { // last part of list
                low = mid + 1;
            } else if (comparator.compare(key, a[mid + 1]) == 0) { // mid matches but not done
                low = mid + 1;

            } else {
                return mid;
            }
        }
        return -1;
    }

    // unit testing (you should have some Unit Testing here to confirm that your
    // methods work)
    public static void main(String[] args) {
        Integer[] numbers = {10, 10, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 2, 2, 2, 1, 1, 1};
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 10, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 10, Collections.reverseOrder()));
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 9, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 9, Collections.reverseOrder()));
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 4, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 4, Collections.reverseOrder()));
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 0, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 0, Collections.reverseOrder()));
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 11, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 11, Collections.reverseOrder()));
    }
}