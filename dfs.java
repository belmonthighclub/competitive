
import java.util.*;

public class dfs {

	public static void main(String[] args) {
		Kid[] kids = new Kid[7];
		kids[0] = new Kid("Nicky", 11);
		kids[1] = new Kid("Anya", 11);
		kids[2] = new Kid("Oleg", 10);
		kids[3] = new Kid("Daniel", 9);
		kids[4] = new Kid("Vivian", 9);
		kids[5] = new Kid("Lauren", 11);
		kids[6] = new Kid("Jonathan", 9);
		
		HashMap<Kid, ArrayList<Kid>> map = new HashMap<>();
		
		for(Kid k : kids) {
			map.put(k, new ArrayList<Kid>());
			for(Kid other : kids) {
				if(k == other) continue;
				if(k.grade == other.grade) {
					map.get(k).add(other);
				}
			}
		}
		
//		for(Kid k : map.keySet()) {
//			System.out.println(k.name + ":");
//			for(Kid other : map.get(k)) {
//				System.out.println(other.name);
//			}
//			System.out.println();
//		}
		
		System.out.println("Are Nicky and Vivian in the same grade?");
		System.out.println(dfs(kids[0], kids[4], map, new HashSet<Kid>()));
		System.out.println();
		System.out.println("Are Nicky and Anya in the same grade?");
		System.out.println(dfs(kids[0], kids[1], map, new HashSet<Kid>()));
		
	}
	
	static boolean dfs(Kid start, Kid target, HashMap<Kid, ArrayList<Kid>> map, HashSet<Kid> visited) {
		if(start == target) return true;
		if(visited.contains(start)) return false;
		
		visited.add(start);
		
		for(Kid neighbor : map.get(start)) {
			boolean b = dfs(neighbor, target, map, visited);
			if(b) return b;
		}
		
		return false;
		
	}
	
	static class Kid {
		String name;
		int grade;
		
		Kid(String s, int g) {
			name = s;
			grade = g;
		}
		
	}

}
