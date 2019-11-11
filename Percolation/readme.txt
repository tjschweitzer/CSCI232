/******************************************************************************
 *  Name: Trent Schweitzer
 *  NetID: 790560101
 *
 *  Hours to complete assignment (optional): 10 ish maybe I dont know didn't use stopwatch
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/


The way I implemented the check to see if the system percolates was by making  two independent quick find arrays, they both had a node at index 0 be seen as the source and when a site on the top row opened up I had it automatically connect to the source node. I also had a node in only one of the arrays that was in the N*N+1 spot that was seen as the sink. The arrays with the sink node was used only to determine percolation and the the other array was used to test if a site was full or not, this helped to prevent back fill.

/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to around
 *  60 seconds. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be a multiple of the preceding data point
 *****************************************************************************/

(keep T constant)
T=1000

 n          time (seconds)
------------------------------
25		0.310
50		0.912
100		4.662
200		33.484
400		301.884

(keep n constant)
N=100

 T          time (seconds)
------------------------------
500		2.460
1000		4.615
2000		8.941
4000		17.810
8000		37.479


/******************************************************************************
 *  Using the empirical data from the above two tables, give an estimate
 *  of the running time of PercolationStats.java as function of both n and 
 *  T, using asymptotic notation, like:
 *
 *       O( n^3.172 * T^1)
 *
 *  Recall that with asymptotic notation, you are interested in the
 *  growth rate of run time as input sizes grow - you drop lower-order
 *  terms and constant factors. In class, we've discussed a way to 
 *  estimate polynomial factors from empirical run times.
 *
 *  How does this estimate compare to the theoretical run time growth
 *  rate, according to analysis of your code?
 *
 *****************************************************************************/

Running time as a function of n and T:  O( N^3.2 * T^1  )

		

/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant)
T=1000

 n          time (seconds)
------------------------------
25		0.252
50		0.468
100		1.280
200		4.584
400		22.187

(keep n constant)
N=100

 T          time (seconds)
------------------------------
500		0.774
1000		1.257
2000		2.372
4000		4.430
8000		9.236

running time (in seconds) as a function of n and T:  ~N^2.2*T^1


/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an n-by-n grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/



N*N+1  Quick find  8N*N+12  
N*N+2  Quick find  8N*N+20 
N*N Boolean N*N Bite   N*N
4 integer	          4
object overhead          8



		   17N^2+44 bites


N*N Bool		n*n
4 ints			16

2(n*n+1)+1 ints        8(n*n+2) 8n^2+16

2*(n*n+2) +1  ints  	8(n*N+3) 8n^2+24

17n^2+56
 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
No bugs that I have found as of yet. With the way the function slows down with larger grids I would say that that is its largest limitation.



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Addison helped me debug some of my code during one of our labs.
Andrew Kattine-Grimsley - help with finding the big O notation and he let me barrow his calculator


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I ran in to some problems with back fill and then finding a way to make sure my code had a constant run time. I also had a lot of issues with getting the index values, so I ended up creating a function that dd that calculation for me.

Finding big Theta was a issue initially



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I enjoyed this program allot I feel that the read me file was not very well explained  I feel like it was benifital to do after I understood what it was asking.
