
import java.util.*;
import java.io.*;

public class guess {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("guess.in"));
		int n = in.nextInt();
		
		HashMap<String, HashSet<String>> map = new HashMap<>(); 
		// key is the name of the animal
		// value is set of characteristics it has
		
		for(int i = 0; i < n; i++) {
			String type = in.next();
			int k = in.nextInt();
			map.put(type, new HashSet<String>());
			for(int j = 0; j < k; j++) {
				map.get(type).add(in.next());
			}
		}
		
		in.close();
		
		int result = 0;
		
		for(String a : map.keySet()) { // check each animal
			for(String b : map.keySet()) { // and compare it with every other animal
				if(a.equals(b)) continue; // use this to avoid comparing an animal to itself
				int commonCount = 0;
				
				for(String c : map.get(a)) { // loop through animal a's traits
					if(map.get(b).contains(c)) {
						// does animal b have trait c?
						// if yes, increase count
						commonCount++;
					}
				}
				if(commonCount != map.get(a).size()) {
					commonCount++;
				}
				
				// maximize
				result = Math.max(commonCount, result);
			}
		}
		
		PrintWriter out = new PrintWriter(new File("guess.out"));
		out.print(result);
		out.close();

	}
	
	

}
