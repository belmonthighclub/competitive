
import java.util.*;
import java.io.*;

public class bfs {
	
	// static means that it's part of the class, can be accessed from anywhere
	static HashMap<String, ArrayList<String>> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // number of people
		int m = in.nextInt(); // number of connections
		
		// read in names of the people, add them to the map
		for(int i = 0; i < n; i++) {
			String name = in.next();
			map.put(name, new ArrayList<String>());
		}
		
		// now make connections between people
		// b is added to a's list
		// a is added to b's list
		for(int i = 0; i < m; i++) {
			String a = in.next();
			String b = in.next();
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		String start = in.next();
		String target = in.next();
		
		int result = bfs(start, target); // call bfs function to get the distance between them
		
		if(result <= 6 && result > -1) {
			System.out.println(start + " is within six degrees away from " + target);
		} else if(result > 6) {
			System.out.println(start + " and " + target + " are too far apart!");
		} else {
			System.out.println(start + " is not connected to " + target + " at all :(");
		}
		
	}
	
	static int bfs(String start, String target) {
		ArrayDeque<String> people = new ArrayDeque<>();
		ArrayDeque<Integer> degrees = new ArrayDeque<>();
		HashSet<String> visited = new HashSet<>(); 
		
		people.add(start);
		degrees.add(0); 
		
		while(!people.isEmpty()) { 
			String cur = people.poll(); 
			int curDegrees = degrees.poll(); 
			
			if(cur.equals(target)) return curDegrees;
			if(visited.contains(cur)) continue; 
			
			visited.add(cur); 
			for(String neighbor : map.get(cur)) {
				people.add(neighbor);
				degrees.add(curDegrees + 1); 
			}
			
		}
		
		return -1;
		
	}

}


/*

https://en.wikipedia.org/wiki/Six_degrees_of_separation

The principle of six degrees of separation is the idea that all people are six or fewer social connections away from each other. 
Given a set of connections, check if two people satisfy this principle. 

Input:
First two numbers are N (number of people) and M (number of connections).
The next N lines contains the N names of the people. 
The next M lines contains the connections between the people.
The last line contains two names. Check if the two names/people satisfy the principle of six degrees separation. 

*/
