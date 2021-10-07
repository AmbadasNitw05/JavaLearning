package my.learning.leetcode.array;

public class SpecialQuadruplets {

	// brute force
	public int countQuadruplets(int[] nums) {
        int cnt = 0, len = nums.length;
        for(int i=0; i<len; i++) {
        	for(int j=i+1; j<len; j++) {
        		for(int k=j+1; k<len; k++) {
        			for(int l=k+1; l<len; l++) {
        				if(nums[i] + nums[j] + nums[k] == nums[l]) {
        					cnt++;
        				}
        			}
        		}
        	}
        }
        return cnt;
    }

	public static void main(String[] args) {
		System.out.println(new SpecialQuadruplets().countQuadruplets(new int[] {1,2,3,6}));

	}

}
