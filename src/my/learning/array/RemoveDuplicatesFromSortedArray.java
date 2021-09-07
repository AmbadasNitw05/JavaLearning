package my.learning.array;

public class RemoveDuplicatesFromSortedArray {

	// Optimized with inserting 
	public int removeDuplicates(int[] nums) {
		if(nums.length <= 1) return nums.length;
		
		int left = 0, right=1;
		while(right<nums.length) {
			if(nums[left] == nums[right]) {
				right++;
			}else {
				nums[left+1] = nums[right];				
				left++;
				right++;
			}
		}
		
		return left+1;
		
	}
	
	public int removeDuplicates1(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(j==0 || nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
	
	// Optimized solution
	public int removeDuplicates2(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){        	
            if(nums[j] != nums[i]){
            	i++;
                nums[i] = nums[j];                
            }
        }
        
        return i+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
