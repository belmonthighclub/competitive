
// http://www.usaco.org/index.php?page=viewproblem2&cpid=855

import java.util.*;
import java.io.*;

public class mixmilk {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("mixmilk.in"));
		
		int[][] arr = new int[3][2];
		
		for(int i = 0; i < 3; i++) {
			arr[i][0] = in.nextInt(); // bucket size
			arr[i][1] = in.nextInt(); // amount of milk in bucket
		}
		
		in.close(); // close Scanner when you finish reading input
		
		for(int i = 0; i < 100; i++) {
			int from = i%3;
			int to = (i+1)%3;
			
			if(arr[from][1] >= arr[to][0]-arr[to][1]) { // "from" can fill up "to"
				arr[from][1] -= (arr[to][0]-arr[to][1]); 
				arr[to][1] = arr[to][0]; 
			} else { // "from" cannot fill up "to" but it'll give all the milk it has
				arr[to][1] += arr[from][1]; 
				arr[from][1] = 0;
			}
		}
		
		
		PrintWriter out = new PrintWriter(new File("mixmilk.out"));
		out.println(arr[0][1]);
		out.println(arr[1][1]);
		out.println(arr[2][1]);
		out.close();
		
	}

}


/*

Input:

10 3    <-- first number is bucket capacity, second number is initial amount of milk
11 4    <-- this bucket can hold up to 11 units of milk, it currently has 4 units of milk
12 5



Step 1: Read in the input and store in a 2D array.

A 2D array is an array of arrays. Can also be viewed as a matrix or grid.

In this case it would be:
[10, 3]
[11, 4]
[12, 5]

2D arrays have rows and columns. 
The above array has 3 ROWS and 2 COLUMNS.
Each row represents a bucket, and the two columns represent two pieces of info about each bucket

Initializing a 2D array:
int[][] arr = new int[3][2];
(creates an array with 3 rows and 2 cols)

Accessing elements from a 2D array:
int[0][1]
(0 is the row index, 1 is the column index)
(this would get the element in the zero-th row and first column --> 3)



Step 2: Simulate the pours.

Farmer John is doing 100 pours, so we'll use a for loop that iterates 100 times. 
Each iteration in the for loop represents one pour.

We use variables "from" and "to" for indexes of the buckets that we're pouring from and to.

% (modulo) is circular:
0 % 3 = 0
1 % 3 = 1
2 % 3 = 2
3 % 3 = 0
4 % 3 = 1
5 % 3 = 2
6 % 3 = 0
...     ^ these will be the indexes for our "from" bucket

Now we have the index for the from bucket, what about the to bucket?
1 -> 2, 2 -> 3, 3 -> 1
"to" will just be the next bucket after "from"
but to make sure that 3 pours to 1, we'll use modulo, so the formula becomes: (i+1)%3

so we've established that:
from = i % 3
to = (i+1) % 3


Now let's actually simulate the pours.
Farmer John is trying to pour as much as he can from bucket "from" to bucket "to"

Two cases:

1. "from" has enough milk to fill "to" up to the top.
   example: "from" has 10 units of milk, "to" has a capacity of 7 and has 3 units of milk
            "to" can take 4 more units of milk (7-3 = 4)
            "from" has more than 4 units of milk (10 >= 4), so it can fill "to" up to 7, and "from" will have 6 units of milk (10-4 = 6)
            
2. "from" does not have enough milk to fill up "to" to the top, but it'll pour as much as it can (all)
   example: "from" has 3 units of milk, "to" has a capacity of 15 and has 10 units of milk
            "to" can take 5 more units of milk (15-10 = 5)
            "from" cannot fill "to" up to 15 (3 < 5)
            but "from" will still do the best it can to fill "to" up, so "from" will give all it's milk to "to"
            so "from" loses 3 units of milk and becomes empty, "to" reaches a capacity of 13 (10+3 = 13)
            
^ this is represented by the if-else



Step 3: Print output to file.
(Some problems have input/output from a file, others are from console.)

Use PrintWriter to print to file. 
Make sure you close it at the end!

*/