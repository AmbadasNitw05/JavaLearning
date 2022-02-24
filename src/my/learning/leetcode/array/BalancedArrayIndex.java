package my.learning.leetcode.array;

public class BalancedArrayIndex {

	// find out the index for which the left sum and right sum should be equal
	
	// Failed solution
	public int getBalancedIndex(int[] nums) {
		int len = nums.length;
		if(len == 1) return 0;
		int leftIndex = 0;
		int rightIndex = len-1;
		int leftSum = 0;
		int rightSum = 0;
		while(leftIndex < rightIndex) {						
			if(leftSum == rightSum ) {
				
				  //if(leftIndex == rightIndex-2) { return leftIndex+1; }				 
				
				leftSum += nums[leftIndex];	
				rightSum += nums[rightIndex];
				leftIndex++;
				rightIndex--;
			}else if(leftSum < rightSum) {				
				leftSum += nums[leftIndex];
				leftIndex++;
			}else {				
				rightSum += nums[rightIndex];
				rightIndex--;
			}			
		}
		
		return leftSum == rightSum ? leftIndex : -1;
	}
	
	public int getPivotIndex(int[] nums) {
		int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; sum += nums[i++])
            if (sum * 2 == total - nums[i]) return i;
        return -1;  
	}
	
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		BalancedArrayIndex bai = new BalancedArrayIndex();
		System.out.println(bai.getBalancedIndex(nums));

	}

}
