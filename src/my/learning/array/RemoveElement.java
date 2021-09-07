package my.learning.array;

public class RemoveElement {

	// Optimized solution 1: two pointers
	public int removeElement(int[] nums, int val) {
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	// Optimized solution 2 - two pointers when elements are rare to remove
	public int removeElement1(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else {
				i++;
			}

		}
		return n;
	}

	// My worst solution
	public int removeElement2(int[] nums, int val) {
		int k = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == val) {
				for (int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				k++;
			}
		}

		return nums.length - k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
