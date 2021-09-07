package my.learning;

import java.util.ArrayList;
import java.util.List;

public class MaxSumNoAdjacent {
	
	public static int rob(int[] nums) {
		if(nums.length == 0) return 0;
		
		// Dynamic Programming
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		dp.add(nums[0]);
		for(int i=1;i<nums.length;i++) {
			dp.add(Math.max(dp.get(i), dp.get(i-1)+nums[i]));
		}
		
		return dp.get(dp.size()-1);
		
	}

	public static void main(String[] args) {

		System.out.println(MaxSumNoAdjacent.rob(new int[] {2,1,1,2}));
	}

}