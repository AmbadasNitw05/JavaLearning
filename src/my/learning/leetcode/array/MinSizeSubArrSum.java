package my.learning.leetcode.array;

public class MinSizeSubArrSum {

	public int minSubArrayLen(int target, int[] nums) {
		int ans = Integer.MAX_VALUE;
		int len = nums.length, sum = 0, left = 0;
		for(int i=0; i<len; i++) {
			sum += nums[i];			
			while(sum >= target) {
				ans = Math.min(ans, i - left + 1);
				sum -= nums[left++];
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
	
	// worst solution with 225 ms in leetcode
	public int minSubArrayLen1(int target, int[] nums) {
		int minLen = Integer.MAX_VALUE, sum = 0, left = 0, i = 0;
		while (i < nums.length) {
			if (nums[i] >= target)
				return 1;
			sum += nums[i];
			if (sum >= target) {
				minLen = Math.min(minLen, i - left + 1);
				i = left = left + 1;
				sum = nums[i];
			}
			i++;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		System.out.println(new MinSizeSubArrSum().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));

	}

}
