
// http://www.usaco.org/index.php?page=viewproblem2&cpid=987

import java.util.*;
import java.io.*;

public class word {

	public static void main(String[] args) throws FileNotFoundException {
		// comment out the scanner that you're not using, this is just for testing purposes
		Scanner in = new Scanner(new File("word.in")); // use this if submitting to usaco site
		Scanner in = new Scanner(System.in); // use this scanner for testing in console
		int n = in.nextInt();
		int k = in.nextInt();
		
		in.nextLine();
		String[] arr = in.nextLine().split(" ");
		// System.out.println(Arrays.toString(arr));
		
		PrintWriter out = new PrintWriter(new File("word.out"));
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			String cur = arr[i];
			if(count + cur.length() <= k) {
				if(count != 0) {
					System.out.print(" ");
					out.print(" ");
				}
				System.out.print(cur);
				out.print(cur);
				count += cur.length();
			} else {
				System.out.println();
				out.println();
				System.out.print(cur);
				out.print(cur);
				count = cur.length();
			}
		}
		
		// System.out.print prints out to the console
		// out.print uses that PrintWriter we made to print to a file (for submitting)

		in.close();
		out.close();
		
		
	}

}
