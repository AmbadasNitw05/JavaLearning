package my.learning.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	// Given an integer array nums of unique elements, return all possible subsets (the power set).

    // The solution set must not contain duplicate subsets. Return the solution in any order.
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(nums, list, new ArrayList<Integer>(), 0);
		return list;
    }
	
	private static void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList, int start) {
		list.add(new ArrayList<Integer>(tempList));
		for(int i=start; i<nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(nums, list, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		System.out.println(subsets(nums));

	}

}
