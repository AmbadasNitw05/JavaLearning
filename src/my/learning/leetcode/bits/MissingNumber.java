package my.learning.leetcode.bits;

public class MissingNumber {
	/* 
	 * Given an array nums containing n distinct numbers in the range [0, n], 
	 * return the only number in the range that is missing from the array.
	 * 
	 * */
	// Using bit manipulation
	// n ^ n = 0 -> using this logic we can achieve this
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for(int i=0; i<nums.length; i++) {
			res = res^i^nums[i];
		}
		return res;
	}
	
	// time - O(n)   space - O(1)
	public int missingNumber1(int[] nums) {
		int res = nums.length;
		
		for(int i=0; i<nums.length; i++) {
			res += (i - nums[i]);
		}
		
		return res;
	}
	
	// time - O(n)   and space - O(n)
	public int missingNumber2(int[] nums) {
        int len = nums.length;
        int[] cache = new int[len+1];
        
        for(int i=0; i<len; i++){
            cache[nums[i]] = 1;
        }
        
        for(int i=0; i<=len; i++){
            if(cache[i] == 0) return i;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
