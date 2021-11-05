package my.learning.array;

public class LinearSearch {
	
	public int iter(int[] nums, int item) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == item)
				return i;
		}
		
		return -1;
	}
	
	public int rec(int[] nums, int item, int index) {		
		if(index == nums.length) return -1;
		if(nums[index] == item) return index;
		return rec(nums, item, index+1);
	}

	public static void main(String[] args) {
		LinearSearch ls = new LinearSearch();
		int[] nums = new int[] {4, -5, 2, 100, 0, 200, 3};
		System.out.println(ls.rec(nums, 3, 0));
	}

}
