package my.learning.array;

import java.util.Arrays;

public class ProductExceptSelf {

	// Input: nums = [1,2,3,4]
	// Output: [24,12,8,6]
	// You must write an algorithm that runs in O(n) time and without using the division operation.
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        
        for(int i=1; i<len; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        
        int right = 1;
        // rev-order 4*3*2 - 4*3 - 4 - 1
        for(int i=len-1; i>=0; i--){
            res[i] =res[i] * right;
            right = right * nums[i];            
        }
        
        // products
        // in-order 	1    -   1    - 1*2   - 1*2*3
        // rev-order 4*3*2   -  4*3   -  4    -   1
        // final	 1*4*3*2 - 1*4*3  - 1*2*4 - 1*2*3*1
        
        return res;
    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4};
		int[] res = ProductExceptSelf.productExceptSelf(nums);
		System.out.println(Arrays.toString(res));

	}

}
