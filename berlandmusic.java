
import java.util.*;
import java.io.*;

public class berlandmusic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int c = 0; c < t; c++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			String str = br.readLine();
			PriorityQueue<Integer> like = new PriorityQueue<Integer>();
			PriorityQueue<Integer> dislike = new PriorityQueue<Integer>();
			
			for(int i = 0; i < n; i++) {
				char cur = str.charAt(i);
				if(cur == '0') {
					dislike.add(arr[i]);
				} else {
					like.add(arr[i]);
				}
			}
			
			int temp = dislike.size();
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 1; i <= temp; i++) {
				map.put(dislike.remove(), i);
			}
			
			for(int i = n-like.size()+1; i <= n; i++) {
				map.put(like.remove(), i);
			}
			
			for(int i = 0; i < n; i++) {
				if(i != 0) System.out.print(" ");
				System.out.print(map.get(arr[i]));
			}
			System.out.println();
			
			
		}

	}

}
