package my.learning.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	/*
	 * Given an array of distinct integers candidates and a target integer target, 
	 * return a list of all unique combinations of candidates 
	 * where the chosen numbers sum to target. You may return the combinations in any order.
	 * 
	 * Input: candidates = [2,3,6,7], target = 7
		Output: [[2,2,3],[7]]

	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;        
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<Integer>(tempList));
        else{
            for(int i=start; i<nums.length; i++){
                tempList.add(nums[i]);
                
                // not i + 1 because we can reuse same elements
                backtrack(list, tempList, nums, remain-nums[i], i);              
                
                tempList.remove(tempList.size()-1);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
