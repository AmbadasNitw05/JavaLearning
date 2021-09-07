package my.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
	// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
	// Copied solution
	public List<List<Integer>> threeSum(int[] nums) {
        // First thought: using three nested loops. 
		// it may or may not work but Not effective. so ignored
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		if(nums.length < 3) return new ArrayList<List<Integer>>();
		
		// sort the array first
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++) {
			
			if(i>0 && nums[i-1] == nums[i]) continue;
			
			int j=i+1, k=nums.length-1;			
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum > 0) {
					k--;
				}else if(sum < 0){
					j++;
				}else {
					output.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while(j<nums.length-1 && nums[j+1]==nums[j]) 
						j++;
					j++;
					while(j<k && nums[k-1]==nums[k])
						k--;
					k--;					
				}
			}
		}
		
		
		return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
