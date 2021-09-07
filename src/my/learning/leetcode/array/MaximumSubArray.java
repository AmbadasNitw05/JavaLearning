package my.learning.leetcode.array;

public class MaximumSubArray {

	public int solution(int[] nums) {
		int len = nums.length;
		if(len == 1) return nums[0];
		
		int maxEndingHere = nums[0], max = nums[0];
		
		for(int i = 1; i<len; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			max = Math.max(maxEndingHere, max);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaximumSubArray().solution(new int[] {-1, 2, 3, 0 , 4, 1, -2 }));
	}
}
