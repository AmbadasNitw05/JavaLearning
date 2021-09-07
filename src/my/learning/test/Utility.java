package my.learning.test;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	public static void main(String[] args) {
		// System.out.println("is 7 even: " + isEvenUsingBitwiseOperator(7));
		int[] nums = {1,2,3,9};
		System.out.println(hasPairWithSum(nums,5));
	}

	public static boolean isEvenUsingBitwiseOperator(int number) {
		return (number & 1) == 0;
	}
	
	// Time complexity O(n), Space Complexity O(n)
	public static boolean hasPairWithSum(int[] data, int sum) {
		List<Integer> complements = new ArrayList<Integer>();
		
		for(int value: data) {
			if(complements.contains(value)) 
				return true;
			
			complements.add(sum-value); 
		}
		
		return false;
	}
}
