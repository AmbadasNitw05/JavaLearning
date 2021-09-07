package my.learning.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {
	
	// another solution
	public int findShortestSubArray1(int[] nums) {
		
		int len = nums.length;
		
		if(len == 1) return 1;
		
		Map<Integer, Integer> left = new HashMap<Integer, Integer>(), 
				right = new HashMap<Integer, Integer>(),
				count = new HashMap<Integer, Integer>();		
		
		for(int i=0; i<len; i++) {
			left.putIfAbsent(nums[i], i);
			right.put(nums[i], i);
			count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
		}
		
		int ans = len;
		int degree = Collections.max(count.values());
		
		for(int x: count.keySet()) {
			if(degree == count.get(x)) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		
		return ans;
		
	}

	public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> first = new HashMap<Integer, Integer>(), 
        		count = new HashMap<Integer, Integer>();
        
        int degree = 0, res = 0;
        for(int i=0; i<nums.length; i++) {
        	first.putIfAbsent(nums[i], i);        	
        	count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        	
        	if(count.get(nums[i]) > degree) {
        		degree = count.get(nums[i]);
        		res = i - first.get(nums[i]) + 1;
        	}else if(count.get(nums[i]) == degree)
        		res = Math.min(res, i - first.get(nums[i]) + 1);
        }
        
        return res;
        
    }

	public static void main(String[] args) {
		System.out.println(new FindShortestSubArray().findShortestSubArray1(new int[] {1,2,2,3,1}));

	}

}
