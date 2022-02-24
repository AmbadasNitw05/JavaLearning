package my.learning.leetcode.array;

public class DuplicatesInArray {
	
	private int[] nums;
	
	// The problem is that we want to find duplicates in a one-dimensional array of integers 
	// in O(N) running time 
	// where the integer values are smaller than the length of the array!
	
	public DuplicatesInArray(int[] nums) {
		this.nums = nums;
	}
	
	public void solve() {
		
		for(int i=0; i<nums.length; i++) {
			if(nums[Math.abs(nums[i])] > 0) {
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];				
			}else {
				System.out.println(Math.abs(nums[i]) + " is the duplicate");
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 3, 4};
		DuplicatesInArray dia = new DuplicatesInArray(nums);
		dia.solve();

	}

}
