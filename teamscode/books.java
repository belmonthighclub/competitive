// package teamscode;

import java.util.*;
import java.io.*;

public class books {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Book[] books = new Book[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int year = Integer.parseInt(st.nextToken());
			books[i] = new Book(name, year);
		}
		Arrays.sort(books);

		for(Book b : books) {
			System.out.println(b.name);
		}
		
	}
	
	static class Book implements Comparable<Book> {
		String name;
		int year;
		
		Book(String a, int b) {
			name = a;
			year = b;
		}
		
		public int compareTo(Book other) {
			if(this.name.charAt(0) == other.name.charAt(0)) {
				return this.year - other.year;
			}
			return this.name.charAt(0) - other.name.charAt(0);
		}
		
	}

}
