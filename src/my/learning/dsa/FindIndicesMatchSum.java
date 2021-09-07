package my.learning.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIndicesMatchSum {
	
	// Memory efficient O(1) but not time efficient O(n^2)
	public static int[] twoSumWithNestedForLoop(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(i==j){
                    break;
                }
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
	
	// Time efficient O(n) but not memory efficient O(n) comparing to the above example
	public static int[] twoSumWithList(int[] nums, int target) {
		List<Integer> previousNums = new ArrayList<Integer>();
		
		Integer comp = null;
		for(int i=0; i<nums.length; i++) {
			comp = target-nums[i];
			if(previousNums.contains(nums[i])) {
				return new int[] {previousNums.indexOf(nums[i]), i};
			}
			previousNums.add(comp);
		}
		
		return new int[0];
	}
	
	// time efficient O(n) and less memory efficient O(n)
	public static int[] twoSumWithMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int i=0;i<nums.length;i++){
			 if(map.containsKey(target-nums[i])) {
				 return new int[] {map.get(target-nums[i]), i};
			 }
			 map.put(nums[i], i);
		 }
		 return new int[0];
	}
	
	// Incorrect solution. won't work for [3,3], 6
	public static int[] twoSum4(int[] nums, int target) {
		 for(int i=0;i<nums.length-1;i++){
			 int index = Arrays.binarySearch(nums, i+1, nums.length, Math.abs(target-nums[i]));
			 if(index <= 0 || i == index) {
				 continue;
			 }
			 return new int[] {i,index};
		 }
		 return new int[]{};
	}
	
	/*
	 * // public static int[] twoSum3(int[] nums, int target) { // List<Integer>
	 * list = Arrays }
	 */

	public static void main(String[] args) {
		int[] data = {1, 2, 4,3,9};
		int target = 6;
		System.out.println(Arrays.toString(FindIndicesMatchSum.twoSumWithNestedForLoop(data, target)));
		System.out.println(Arrays.toString(FindIndicesMatchSum.twoSumWithList(data, target)));
		System.out.println(Arrays.toString(FindIndicesMatchSum.twoSumWithMap(data, target)));
	}

}
