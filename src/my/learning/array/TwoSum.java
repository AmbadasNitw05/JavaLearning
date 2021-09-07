package my.learning.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		 Map<Integer, Integer> map = new HashMap<>();
	        
	        for(int i=0; i<nums.length; i++){
	            if(map.containsKey(target-nums[i])){
	                return new int[]{i, map.get(target-nums[i])};
	            }
	            map.put(nums[i], i);
	        }        
			
			return new int[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
