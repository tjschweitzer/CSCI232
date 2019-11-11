/******************************************************************************
 *  Name:     Trent Schweitzer
 *
 *  Hours to complete assignment (optional): 8 to 10 
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

I have it work like a binary search but when it equals the value I am looking for, for the firstindexof it looks at the previous value in the array to find the first one the equals the required key.


/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: n*log(n) + n

allMatches(): log N  + m*log(m)
            

numberOfMatches(): 2log(n)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
The only limit is your imagination.  - Trent Schweitzer 2019 


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I would like to thank The Dram Shop for giving me a warm place to work on my code and The Artist “Chilledcow” for their spotify playlist.

Issac was able  to help me talk though an off by one error in my Autocomplete.allMatches class

Addison at Study Jam was helpful as always in helping with my binary search tree
/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I can not count the number of endless loops I ran in to while trying to get my binary tree to work, I also ran in to an off by one error in the auto complete class where I was allocating  one to many spots in an array so when it would try and sort all items it was coming up with a null pointer exception

I kept getting “ Failed to load module "canberra-gtk-module" “ and had to install something to fix that. 


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

This was a fun challenge to work though, I Would have liked to have a smaller set of text provided.


