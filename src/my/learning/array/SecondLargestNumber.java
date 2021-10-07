package my.learning.array;

public class SecondLargestNumber {
	
	// return second largest in the number array. Ex: [3, 4, 2, 0] -> 3
	// return -1 if there is no second largest. Ex: [2,2,2,2], [3]
	
	// Time Complexity 0(n) , Space complexity (1)
	public static int getSecondLargestNumber(int[] nums) {
		
		int len = nums.length;
		if(len < 2) return -1;
		
		int max1 = Math.max(nums[0], nums[1]);
		int max2 = Math.min(nums[0], nums[1]);
		
		for(int i=2;i<len;i++) {
			if(max1 > nums[i]) {
				if(nums[i] > max2)
					max2 = nums[i];
			}else if(max1 < nums[i]){
				int temp = max1;
				max1 = nums[i];
				max2 = temp;
			}
		}
		
		if(max1 == max2) return -1;
		else return max2;
	}

	public static void main(String[] args) {
		System.out.println(SecondLargestNumber.getSecondLargestNumber(new int[] {3})); // -1
		System.out.println(SecondLargestNumber.getSecondLargestNumber(new int[] {2,2,2,2,2})); // -1
		System.out.println(SecondLargestNumber.getSecondLargestNumber(new int[] {3, 2, 5, 7, 1})); // 5
		
		int[] bigArr = new int[100000];
		System.out.println(SecondLargestNumber.getSecondLargestNumber(bigArr)); // -1
		
		for(int i=0;i<100000;i++) {
			bigArr[i] = i;
		}
		
		System.out.println(SecondLargestNumber.getSecondLargestNumber(bigArr)); // 99998
	}

}
