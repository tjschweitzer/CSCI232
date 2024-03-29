import java.util.Random;


class HashProbing{
    Integer[] myArray;
    Integer myCounterInteger;
    public HashProbing(int N) {
       Random rand = new Random();
       myCounterInteger=0;
       myArray = new Integer[N];
       for (int i = 0; i < N/2; i++) {
           insert(rand.nextInt(N-1)); 
       }
           
           
       for (int i = 0; i < N/2; i++) {
       countCol(rand.nextInt(N-1));
           
       }
    }
    
    public void countCol(int M) {
        myCounterInteger++;
        while(myArray[M]!=null) {
            M=(M+1)%myArray.length;
            myCounterInteger++;
        }
    }
    
    public int getCount() {
        return myCounterInteger;
    }
    
    public void insert(int M) {
        while (myArray[M]!=null) {
            M=(M+1)%myArray.length;
        }        
        myArray[M]= M;
    }
    
    public static void main(String[] args) {
        for (int i = 3; i <=6; i++) {
            int power = (int)Math.pow(10, i);
            //StdOut.println(power);
            HashProbing myHashyHashProbing = new HashProbing(power);
            StdOut.println("10^"+i+"  "+(float)myHashyHashProbing.getCount()/(power/2.0));
        }
    }
}