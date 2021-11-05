package my.learning.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {

	/*
	 * Given an array of distinct integers nums and a target integer target, 
	 * return the number of possible combinations that add up to target.
	 * 
	 * Input: nums = [1,2,3], target = 4
		Output: 7
		Explanation:
		The possible combination ways are:
		(1, 1, 1, 1)
		(1, 1, 2)
		(1, 2, 1)
		(1, 3)
		(2, 1, 1)
		(2, 2)
		(3, 1)
		Note that different sequences are counted as different combinations.
	 */
	// Use dynamic programming for optimization
	// Accepted solution in leetcode
	private int[] dp;
    public int combinationSum4_1(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target);
        return dp[target];
    }
    
    private int helper(int[] nums, int target){
        if(dp[target] != -1) return dp[target];
        
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(target >= nums[i])
                res += helper(nums, target - nums[i]);
        }
        
        dp[target] = res;        
        return res;
    }
    
	// brute force with backtracking. Time Limit Exceeded will happen	
	public int combinationSum4_2(int[] nums, int target) {
        return backtrack(nums, new ArrayList<Integer>(), target, 0);
    }
    
    private int backtrack(int[] nums, List<Integer> tempList, int remain, int count){
        if(remain < 0) return count;
        else if(remain == 0) count++;
        else{
            for(int i=0; i<nums.length; i++){
                tempList.add(nums[i]);
                count = backtrack(nums, tempList, remain - nums[i], count);
                tempList.remove(tempList.size()-1);
            }
        }
        
        return count;
    }
    
    // Another backtrack solution
    public int combinationSum4(int[] nums, int target) {
    	if(target == 0)
        	return 1;
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            if(target >= nums[i])
        	    res += combinationSum4(nums, target-nums[i]);
        }
        return res;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
