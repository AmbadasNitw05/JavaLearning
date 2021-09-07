package my.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	
	// Optimized way
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, 0, 4, target);
	}

	public List<List<Integer>> fourSum2(int[] nums, int target) {
        
		// 1. sort the array
		// 2. loop through elements
		// 3. a+b+c+d = target
		if(nums.length < 4) return new ArrayList<List<Integer>>();
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-3;i++) {
			if(i>0 && nums[i-1] == nums[i]) continue;
			for(int j=i+1;j<nums.length-2;j++) {
				if(j>i+1 && nums[j] == nums[j-1]) continue;
				int k=j+1,l=nums.length-1;
				while(k<l) {
					if(k>j+1 && nums[k] ==  nums[k-1]) {
						k++;
						continue;
					}
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if(sum > target) l--;
					else if(sum < target) k++;
					else {
						output.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
						
						if(k<nums.length-1 && nums[k] == nums[k+1])
							k++;
						k++;
						if(k<l && nums[l] == nums[l-1])
							l--;
						l--;
					}
				}
			}
		}
		
		return output;
    }
	
	// FYI: input array is sorted array
	public List<List<Integer>> kSum(int[] nums, int start, int k, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length == start || nums[0]*k > target || nums[nums.length-1]*k < target)
			return res;
		
		if(k == 2)
			return twoSum(nums, start, target);
		
		for(int i=start; i<nums.length-k+1; i++) {
			if(i==start || nums[i-1] != nums[i]) {
				for(List<Integer> subset: kSum(nums, i+1, k-1, target-nums[i])) {
					res.add(new ArrayList<>(Arrays.asList(nums[i])));
					res.get(res.size()-1).addAll(subset);
				}
			}	
		}
		
		return res;
	}

	// FYI: input array is sorted array
	public List<List<Integer>> twoSum(int[] nums, int start, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=start;i<nums.length;i++) {
			if(res.isEmpty() || res.get(res.size()-1).get(1) != nums[i]) {
				if(set.contains(target-nums[i])) {
					res.add(Arrays.asList(target-nums[i], nums[i]));
				}
			}						
			set.add(nums[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new FourSum().fourSum(new int[] {4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5}, -13));

	}

}
