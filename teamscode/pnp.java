
// package teamscode;

import java.util.*;
import java.io.*;

public class pnp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt(); // max p value
		int y = in.nextInt(); // max n value
		
		int count = 0;
		for(int p = 0; p <= x; p++) {
			for(int n = 0; n <= y; n++) {
				if(p == n*p) count++;
			}
		}
		System.out.println(count);

	}

}
