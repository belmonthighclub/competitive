
import java.util.*;
import java.io.*;

public class prefix {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String ex = in.next();
		 ArrayDeque<Integer> stack = new ArrayDeque<>();
		 
		 for(int i = ex.length()-1; i >= 0; i--) {
			 char cur = ex.charAt(i);
			 if(cur == '+') {
				 int a = stack.pop();
				 int b = stack.pop();
				 stack.push(a + b);
			 } else if(cur == '-') {
				 int a = stack.pop();
				 int b = stack.pop();
				 stack.push(a - b);
			 } else if(cur == '*') {
				 int a = stack.pop();
				 int b = stack.pop();
				 stack.push(a * b);
			 } else if(cur == '/') {
				 int a = stack.pop();
				 int b = stack.pop();
				 stack.push(a / b);
			 } else {
				 stack.push(cur-'0');
			 }
		 }
		 
		 int result = stack.pop();
		 System.out.println(result);
		 
	}

}
