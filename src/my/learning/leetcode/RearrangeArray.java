package my.learning.leetcode;

import java.util.Arrays;

public class RearrangeArray {
	
	public int[] rearrangeArray(int[] nums) {
		
		
		Arrays.sort(nums);
		int temp = 0;
		for(int i=1; i<nums.length; i+=2) {
			temp = nums[i];
			nums[i] = nums[i-1];
			nums[i-1] = temp;
		}
        
        return nums;
    }
	
	
	// Time optimization
	public int[] rearrangeArray2(int[] nums) {
			
		
		for(int i=1; i<nums.length; i++) {
			
			if((nums[i-1] < nums[i] && nums[i] < nums[i+1]) || (nums[i-1] > nums[i] && nums[i] > nums[i+1])) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
			
		}
        
        return nums;
    }

	public static void main(String[] args) {
		// [2, 6, 7, 8, 9, 5, 1]
		
		// sort array
		// [1, 2, 5, 6, 7, 8, 9] 
		
		// swap every two elems
		// [2, 1, 6, 5, 8, 7, 9]

	}

}
