package my.learning.leetcode.dp;

public class HouseRober2 {

	/*
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed. 
	 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
	 */
	
	
	public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        return Math.max(rob(nums,0,len-2), rob(nums, 1, len-1));
    }
	
	public int rob(int[] nums, int start, int end) {
        
        if(start == end) return nums[start];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        int i=0;
        for(i=2; i+start<=end; i++){
            dp[i] = Math.max(dp[i-2] + nums[i+start], dp[i-1]);
        }
        return dp[i-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
