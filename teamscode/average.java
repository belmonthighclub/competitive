// package teamscode;

import java.util.*;
import java.io.*;

public class average {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] scores = new int[n];
		for(int i = 0; i < n; i++) {
			scores[i] = in.nextInt();
		}
		
		Arrays.sort(scores);
		
		double avg = 0;
		for(int i = 1; i < n; i++) {
			avg += scores[i];
		}
		avg /= (n-1);
		
		StringBuilder sb = new StringBuilder();
		String s = avg + "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '.') {
				sb.append(s.charAt(i));
				sb.append(s.charAt(i+1));
				break;
			}
			sb.append(s.charAt(i));
		}
		
		System.out.println(sb.toString());

	}

}
