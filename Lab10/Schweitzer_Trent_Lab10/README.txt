The solution is to sort both arrays, then compare the sorted arrays. How can we sort in linearithmic guaranteed time and constant extra space?

	We can take the heap we have created and by doing DelMax() that takes logarithmic time to run and will run a linear number of time while using constant space in the heaps;

The solution is to place all elements from one array in a hash table, then test if all elements in the other are present in that hash table. What assumption does this make about your hashing function? 

	That the hashing function will evenly distribute the keys kinda evenly though they are integers close to each other.


How effective are these the two methods you've implemented?  
(a) do they work
	Yes
(b) what are the run times of the approaches?

The heap should run about linerrythmic and the Hash run time should be around linear 


Heap		Time		Ratio			Power	
100		.016892221		
10000		.186580883	11.0453730743873	0.521590194708137
1000000		2.590064202	13.881723359622		0.571221692681681
10000000	20.769164143	8.01878352164492	0.904108489243242
			
			
Hash		Time		Ratio			Power
100		0.014731811		
10000		0.146320645	9.93229175964856	0.498524734204068
1000000		3.599547442	24.6004071537547	0.695471147518471
10000000	26.592812889	7.3878211962736		0.868516375884146


In the case of using a hash, what is the impact of the method of collision detection, and the size of the underlying array?

When collisions happens you increment the value of the value of the array if reading from the initial file and decrement if reading from the  2nd file


Heap
100
The two input arrays do match
elapsed time: 0.016892221 seconds
10k
The two input arrays do not match
elapsed time: 0.186580883 seconds
1m
The two input arrays do not match
elapsed time: 2.590064202 seconds
10m
The two input arrays do not match
elapsed time: 20.769164143 seconds


Hash
100
The two input arrays do match
elapsed time: 0.014731811 seconds
10k
The two input arrays do match
elapsed time: 0.146320645 seconds
1mil
The two input arrays do match
elapsed time: 3.599547442 seconds
10mil
The two input arrays do match
elapsed time: 26.592812889 seconds
