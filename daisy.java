
// import packages that we'll use to read input and do other stuff
import java.util.*;
import java.io.*;

public class daisy {

	public static void main(String[] args) {
		
		// reading in input
		// Scanner "scans" the input and then we store it!
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] flowers = new int[n];
		for(int i = 0; i < n; i++) {
			flowers[i] = in.nextInt();
		}
		
		// this variable will store our answer:
		// the number of photos that have an average flower
		int result = 0;
		
		for(int i = 0; i < n; i++) { 
			for(int j = i; j < n; j++) {
				// runs i*j times
				// i and j are the start and end indexes
				// this will give us a subarray from i to j, each subarray is a photo
				
				int sum = 0;
				for(int k = i; k <= j; k++) {
					// looping through each flower in the subarray
					sum += flowers[k];
				}
				
				if(sum % (j-i+1) == 0) {
					// this if statement tells you if the average is a whole number (not a decimal)
					// this is important bc average CANNOT be a decimal (number of flower petals must be a whole number)
					
					// % - modulo, gives you the remainder
					// examples: 12 % 5 = 2
					//           12 % 4 = 0
					
					// calculate the average by dividing the sum by the number of elements (the length)
					// (j-i+1) is the length of the subarray
					int average = sum/(j-i+1); 
					
					// looping through each flower in the subarray (from i to j)
					for(int k = i; k <= j; k++) {
						if(flowers[k] == average) {
							result++;
							break; // this exits the for loop
						}
					}
				}
				
			}
		}
		
		// print the result in the end
		System.out.println(result);

	}

}
