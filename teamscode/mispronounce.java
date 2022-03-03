// package teamscode;

import java.io.*;
import java.util.*;

public class mispronounce {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int order = 0; order < n; order++) {
			int a = Integer.parseInt(br.readLine());
			HashMap<Integer, ArrayList<String>> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < a; i++) {
				String temp = st.nextToken();
				if(map.containsKey(temp.length())) {
					map.get(temp.length()).add(temp);
				} else {
					map.put(temp.length(), new ArrayList<String>());
					map.get(temp.length()).add(temp);
				}
			}
			
			st = new StringTokenizer(br.readLine());
			String size = st.nextToken();
			String drink = st.nextToken();
			String ret1 = "";
			String ret2 = "";
			
			if(size.length() == 6) {
				ret1 = "medium";
			} else {
				String sizeTest = "small";
				int count = 0;
				for(int i = 0; i < 5; i++) {
					if(sizeTest.charAt(i) == size.charAt(i)) count++;
				}
				if(count == 4) ret1 = "small";
				else ret1 = "large";
			}
			
			for(String s : map.get(drink.length())) {
				int count = 0;
				for(int i = 0; i < drink.length(); i++) {
					if(s.charAt(i) == drink.charAt(i)) count++;
				}
				if(count == drink.length()-1) {
					ret2 = s;
					break;
				}
			}
			
			System.out.println(ret1 + " " + ret2);
			
		}
		
	}

}
