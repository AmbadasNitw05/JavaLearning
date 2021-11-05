package my.learning.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class HouseRober {
	
	/*
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, the only constraint stopping you 
	 * from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

		Given an integer array nums representing the amount of money of each house, 
		return the maximum amount of money you can rob tonight without alerting the police.
	 */
	// Dynamic programming solution - optimized because of array for dp
	public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        return dp[len-1];
        
    }
	
	// Dynamic programming - less optimized due to list
	public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
		
		// Dynamic Programming
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		dp.add(nums[0]);
		for(int i=1;i<nums.length;i++) {
			dp.add(Math.max(dp.get(i), dp.get(i-1)+nums[i]));
		}
		
		return dp.get(dp.size()-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
