// package teamscode;

import java.util.*;
import java.io.*;

public class latticeflowers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a = 0, b = 0;
			
			if(n == m) {
				a = n;
				b = 3;
			} else if(n < m) {
				a = m;
				b = 1;
			} else if(n > m) {
				a = n;
				b = 1;
			}
			
			System.out.println(a + " " + b);
			
		}
		
	}

}
