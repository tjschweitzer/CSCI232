import java.util.Arrays;
import java.util.function.ObjDoubleConsumer;
import java.util.zip.Checksum;

import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.TopM;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



//Corner cases.  By convention, the row and column indices are integers between 0 and N − 1, where (0, 0) is the upper-left site:
//    Throw a java.lang.IndexOutOfBoundsException if any argument to open(), isOpen(), or isFull() is outside its prescribed range. 
//    The constructor should throw a java.lang.IllegalArgumentException if N ≤ 0.
//
//Performance requirements.  The constructor should take time proportional to N2;
//all methods should take constant time plus a constant number of calls to the union-find methods union(), find(), connected(), and count().


public class Percolation {
    private WeightedQuickUnionUF myGrid; //will be indexed 1 - (nSize*nSize)
    private WeightedQuickUnionUF myOtherGrid;
    private boolean[][] gridOpen;
    private int openSize; // number of open spots in the grid
    private int nSize; // size of one size of the grid
    private int gridTop; // will be set to gridBottom+1
    private int gridBottom;
    
    public Percolation(int N) {
       // create N-by-N grid, with all sites initially blocked
        
        if (N<1) {
            throw new java.lang.IllegalArgumentException("What are you doing the number must be one or greater!!!!");
        }
        myGrid = new WeightedQuickUnionUF(N*N+1); //N*N items in the grid plus a top node used to check if the grid if full
        myOtherGrid = new WeightedQuickUnionUF(N*N+2);  //N*N items in the grid plus a top and bottom used to check percolation
        gridOpen = new boolean[N][N]; 
        nSize=N;
        openSize =0;
        gridTop=0;
        gridBottom=nSize*nSize+1;
    }
    
        //check if row and col are inbetween 0 and array Size
    private boolean checkIndex(int row, int col) {
        if (col>nSize ||row > nSize ||col<0 ||row < 0 ) { 
            throw new java.lang.IndexOutOfBoundsException("index outside of grid!");
        }
        return true;
    }
    
        //   Takes in a row and col and returns an index value for a 1D Array
   private int indexValue(int row,int col) {
       return (row*nSize)+col+1;
   } 
    
       // open the site (row, col) if it is not open already
   public void open(int row, int col) {
       if((checkIndex(row,col))){
           if (!isOpen(row, col)) {
               openSize++;
               gridOpen[row][col]=true;
           }
           
               // Checks if part of top row  if so connects it to the sink node
           if (row==0) {
               myGrid.union(gridTop,indexValue(row, col));   
               myOtherGrid.union(gridTop, indexValue(row, col));
           }

           // Checks if part of bottom row  if so connects it to the drain node
           if (row==nSize-1) {
               
               myOtherGrid.union(indexValue(nSize, 0), indexValue(row, col));

           }
           
          
           if(row>0) {
               if (gridOpen[row-1][col]) {
                   myGrid.union(indexValue(row-1, col), indexValue(row, col));
                   myOtherGrid.union(indexValue(row-1, col), indexValue(row, col));
               }
           }
           
           //checks if site is on the right side of grid
           if(row<nSize-1) {
               if (gridOpen[row+1][col]) {
                   myGrid.union(indexValue(row+1, col), indexValue(row, col));
                   myOtherGrid.union(indexValue(row+1, col), indexValue(row, col));
               }
           }
           

           //checks if site is on the left side of grid
           if(col>0) {
               if (gridOpen[row][col-1]) {
                myGrid.union(indexValue(row, col-1), indexValue(row, col));

                myOtherGrid.union(indexValue(row, col-1), indexValue(row, col));
               }
           }
           if(col<nSize-1) {
               if (gridOpen[row][col+1]) {
                myGrid.union(indexValue(row, col+1), indexValue(row, col));

                myOtherGrid.union(indexValue(row, col+1), indexValue(row, col));
               }
           }
       }   
   }
   
       // checks if the site is opened
   public boolean isOpen(int row, int col) {
       if (col<0 || col>nSize || col<0 || row > nSize) {
           throw new java.lang.IndexOutOfBoundsException("index outside of grid!");
       }
       return  gridOpen[row][col];
   }
   
// is the site (row, col) full?
   public boolean isFull(int row, int col) {
       
       return myGrid.connected((row*nSize+col+1), gridTop); //does the site connect to the top?
   }
   

   // number of open sites
   public int numberOfOpenSites() {
       return openSize;
   }
   

   // does the system percolate?
   public boolean percolates(){
       return myOtherGrid.connected(gridTop, gridBottom);
   }
   public static void main(String[] args) {
      
       int N = Integer.parseInt(args[0]);
       int T = Integer.parseInt(args[1]);
       PercolationStats item = new PercolationStats(N,T);
   }
}