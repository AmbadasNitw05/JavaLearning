package my.learning.array;

public class MaxProductSubArr {

	// find a contiguous non-empty subarray within the array that has the largest product, and return the product.
	// Input: nums = [2,3,-2,4]
	// Output: 6
	// Explanation: [2,3] has the largest product 6.
	public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int max = nums[0], min = nums[0];
        for(int i=1; i<nums.length; i++){
        	// swapping min, max for -ve value as it makes reverse
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            
            maxProduct = Math.max(max, maxProduct);
            
        }
        
        return maxProduct;
    }
	
	public static void main(String[] args) {
		System.out.println(MaxProductSubArr.maxProduct(new int[] {2,3,-2,4, -2, -1}));
	}

}
