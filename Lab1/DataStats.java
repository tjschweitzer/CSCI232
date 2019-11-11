import java.util.Arrays;

public class DataStats {
    private double[] dataArray;
    private int size;
    public DataStats(int N) {
        dataArray = new double[N];
        size = 0;      //Keeps track of the number of items in the array, or the index of the next value to be assigned
    }

    public double mean() {
        // returns the sum of the array divided by the size of the appended items          
       return (Arrays.stream(dataArray).sum())/size;
    }
        //compute and return the mean of the set of numbers added so far
    
    public void append(double in) {  
      //Tries to add to array and will throw error if outside of preset array size
      try {
          dataArray[size]=in;
          size++;    
      }catch(IndexOutOfBoundsException e){
          System.out.println("Can Not Append Any More!");  
      }
      
    }
     //append number to the set; throw error if more than N numbers added
 }
