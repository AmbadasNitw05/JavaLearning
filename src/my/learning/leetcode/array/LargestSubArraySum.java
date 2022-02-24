package my.learning.leetcode.array;

public class LargestSubArraySum {
	
	// Create an algorithm to find the sum of contiguous subarray 
	// within a one-dimensional array of numbers which has the largest sum!
	public int getLargestSubArraySum(int[] nums) {
		int currentMax = nums[0];
		int globalMax = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			currentMax = Math.max(nums[i], currentMax + nums[i]);
			
			globalMax = Math.max(globalMax, currentMax);
		}
		
		return globalMax;
	}

	public static void main(String[] args) {
		int[] nums = {1, -2, 3, 4, -5, 8};
		LargestSubArraySum obj = new LargestSubArraySum();
		System.out.println(obj.getLargestSubArraySum(nums));

	}

}
