import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
   private double myNum[];
   private double myData[];
   private int myT,myN;
   
   public PercolationStats(int N, int T) {   // perform T independent experiments on an N-by-N grid
       myT=T;
       myN=N;
       myNum = new double[myT];
       myData = new double[4];
   
      
       for (int i =0; i<myT;i++) {
           myNum[i]=0;
               
           Percolation myGrid =new Percolation(myN);
           while(myGrid.percolates()==false) {
    
               myGrid.open(StdRandom.uniform(myN), StdRandom.uniform(myN));
               
       }
       myNum[i]=(double)myGrid.numberOfOpenSites()/(myN*myN);
   }
   myData[0]=mean(); //Mean
   myData[1]=stddev(); //std Dev
   myData[2]= 
   myData[3]= myData[0]+(1.96*myData[1]/Math.sqrt(T)); //High confidence
   StdOut.println("mean()                = "+mean());
   StdOut.println("stddev()              = "+myData[1]);
   StdOut.println("confidenceLow()       = "+myData[2]);
   StdOut.println("confidenceHigh()      = "+myData[3]);
   }
   public double mean() {                    // sample mean of percolation threshold
       return StdStats.mean(myNum);
   }
   
   public double stddev() {                  // sample standard deviation of percolation threshold
       return StdStats.stddev(myNum);
   }
   
   public double confidenceLow() {           // low  endpoint of 95% confidence interval
   return mean()-(1.96*stddev()/Math.sqrt(myT));  // Low confidence
   }
   
   
   
   public double confidenceHigh() {         // high endpoint of 95% confidence interval
   return mean()+(1.96*stddev()/Math.sqrt(myT)); 
   }
   
   public static void main(String[] args) {
       
     
   }
}