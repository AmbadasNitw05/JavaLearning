package my.learning.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	// more faster but less space time O(n), space O(1)
	public int majorityElement(int[] nums) {
		int major = nums[0], count = 1;
		for(int i=1; i<nums.length; i++) {
			if(count == 0) {
				count++;
				major = nums[i];
			}else if(nums[i] == major)
				count++;
			else
				count--;
		}
		
		return major;
	}
	// little faster but less space time O(n), space O(1)
	public int majorityElement2(int[] nums) {
		int len = nums.length;
        if(len == 1) return nums[0];
        
		Arrays.sort(nums);
		
		int i = 1, counter = 1, maxC = 0, maxE = 0;
		while(i < len) {
			if(nums[i] == nums[i-1]) counter++;
			else counter = 1;
			
			if(counter > maxC) {
				maxC = counter;
				maxE = nums[i];
			}
			
			i++;
		}
		
		return maxE;
	}
	
	// old fashioned and not time efficient
	// linear time O(n) and space is O(n)
	public int majorityElement1(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxRep = 0, maxEle = 0;
        for(int num: nums) {
        	if(!map.containsKey(num))
        		map.put(num, 1);
        	else
        		map.put(num, map.get(num)+1);
        	
        	if(map.get(num) > maxRep) {
        		maxRep = map.get(num);
        		maxEle = num;
        	}
        		
        }
        
        return maxEle;
        
    }

	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[] {2,2,1,1,1,2,2}));
	}

}
