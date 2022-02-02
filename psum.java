import java.util.Arrays;

public class psum {

	public static void main(String[] args) {
		int[] array = new int[] {5, 10, 24, 6, 7, 31, 56, 7, -3};
		int[] psum = new int[array.length+1];
		
		for(int i = 1; i < psum.length; i++) {
			psum[i] = psum[i-1] + array[i-1];
		}
		
		System.out.println(Arrays.toString(psum));
		
		System.out.println(psum[6] - psum[3]);
		

	}

}
