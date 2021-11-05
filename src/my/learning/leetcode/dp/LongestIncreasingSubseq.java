package my.learning.leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubseq {

	// Given an integer array nums, return the length of the longest strictly increasing subsequence.
	// Input: nums = [10,9,2,5,3,7,101,18]
	// Output: 4
	// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
	
	// Dynamic Array - time O(n logn)  space O(n)
	public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = nums.length-1; i >= 0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);                    
                }
            }
            max = Math.max(max, dp[i]);
        }        
        return max;
    }
	
	// Binary Search - more optimized way
	public int lengthOfLIS1(int[] nums) {
		int[] lis = new int[nums.length];
		int size = 1;
		lis[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			int index = binarySearch(lis, size, nums[i]);
			if(index == -1) {
				lis[size++] = nums[i];
			}else {
				lis[index] = nums[i];
			}
		}
		
		return size;
	}
	
	private int binarySearch(int[] nums, int size, int target) {
		int l = 0, h = size-1, res = Integer.MAX_VALUE;
		while(l <= h) {
			int mid = l + (h-l)/2;
			if(nums[mid] >= target) {
				res = Math.min(mid, res);
				h = mid - 1;								
			}else {
				l = mid + 1;
			}			
		}
		
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
		
	
	public static void main(String[] args) {
		int[] input = new int[] {10,9,2,5,3,7,101,18};
		LongestIncreasingSubseq lis = new LongestIncreasingSubseq();
		System.out.println(lis.lengthOfLIS1(input));

	}

}
