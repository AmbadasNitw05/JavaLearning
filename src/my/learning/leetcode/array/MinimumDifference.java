package my.learning.leetcode.array;

import java.util.Arrays;

public class MinimumDifference {

	public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) return 0;
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=k-1;i<len;i++) {
        	min = Math.min(nums[i]-nums[i-k+1], min);
        }
        
        return min;
    }
	
	public static void main(String[] args) {
		System.out.println(new MinimumDifference().minimumDifference(new int[] {3, 7, 1, 9}, 2 ));

	}

}
