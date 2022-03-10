
import java.util.*;

public class binarysearch {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = new int[10];
		for(int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random()*20);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int target = (int)(Math.random()*20);
		int left = 0;
		int right = n-1;
		boolean exists = false;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(arr[mid] < target) {
				left = mid+1;
			} else if(arr[mid] > target) {
				right = mid-1;
			} else {
				exists = true;
				break;
			}
		}
		
		System.out.println("Target: " + target);
		System.out.println(exists);
		
	}
	
}
