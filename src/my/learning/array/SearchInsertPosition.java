package my.learning.array;

public class SearchInsertPosition {
	
	// Binary Search through iterative solution
	public int searchInsert2(int[] nums, int target) {
        
		if(nums[0]>=target) return 0;
		if(nums[nums.length-1]<target) return nums.length;
		
		int start = 0, end=nums.length-1, mid=0;
		
		while(start<=end) {
			if(start == end) return start;
            if(end-start == 1) return start+1;
			mid = (start+end)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] < target) {
				start = mid;				
			}else {
				end = mid;
			}
		}
		
		return mid;
		
    }
	
	// Little more optimized
	public int searchInsert3(int[] nums, int target) {
        
		if(nums[0]>=target) return 0;
		if(nums[nums.length-1]<target) return nums.length;
		
		int start = 0, end=nums.length-1, mid=0;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(nums[mid] == target) return mid;
			else if(nums[mid] < target) start = mid+1;
			else end = mid-1;
		}
		
		return start;
		
    }

	// Recursive solution time complexity O(log n)
	public int searchInsert(int[] nums, int target) {
        // nums[0] > target, retun 0
        // nums[len-1] < target, return len
		// nums[len/2] < target, search second half, else search first half recursively
		if(nums[0]>=target) return 0;
		if(nums[nums.length-1]<=target) return nums.length;
		return searchInsertRec(nums, 0, nums.length-1, target);
		
		
    }
	
	private int searchInsertRec(int[] nums, int start, int end, int target) {
		if(start == end) return start;
		if(nums[start] == target) return start;
		if(nums[end] == target) return end;
		if(nums[start]>target) return start-1;
		if(nums[end]<target) return end+1;		
		if(end-start == 1) return start+1;
		
		if(nums[(start+end)/2]<target)
			return searchInsertRec(nums, ((start+end)/2), end, target);
		else
			return searchInsertRec(nums, start, ((start+end)/2), target);
		
	}
	
	public static void main(String[] args) {
		System.out.println(new SearchInsertPosition().searchInsert2(new int[] {1, 3,5},4));

	}

}
