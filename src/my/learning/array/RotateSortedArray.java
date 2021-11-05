package my.learning.array;

public class RotateSortedArray {

	// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
	// Algorithm for the solution of O(log n)
	public int findMin(int[] nums) {
        int start=0, end=nums.length-1;
        
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] < nums[end])
                end = mid; // min is in the left part
            else
                start = mid + 1; // min is in the right part
                
        }       
        
        return nums[start];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
