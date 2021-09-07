package my.learning.leetcode.array;

import java.util.Set;
import java.util.TreeSet;

public class NumOfDiffSubseqGCDs {
	
	public int countDifferentSubsequenceGCDs(int[] nums) {
		int[] factor = new int[200001];
        for (int i = 0; i < nums.length; ++i) {
        	// Find all factors of nums[i]
            for (int j = 1; j * j <= nums[i]; ++j) {
                if (nums[i] % j == 0) {
                    int factor1 = j;
                    int factor2 = nums[i] / j;

        			// Find gcd of all nums[i] with factor1
                    factor[factor1] = gcd(factor[factor1], nums[i]);
                    
        			// Find gcd of all nums[i] with factor2
                    factor[factor2] = gcd(factor[factor2], nums[i]);
                }

            }
        }
        int ans = 0;
        // Check if all nums with one of factors as i form a GCD of i or not.
        for (int i = 1; i <= 200000; ++i ) if (factor[i] == i) ++ans;
        return ans;
	}

	public int countDifferentSubsequenceGCDs1(int[] nums) {
        
        int len = nums.length;
        
        if(len == 1) return nums[0];
        
        Set<Integer> set = new TreeSet<Integer>();
        
        int max = 0;
        
        for(int i=0; i<len; i++) {
        	set.add(nums[i]);
        	max = Math.max(max, nums[i]);        	
        }
        
        for(int i=1; i<max; i++) {
        	
        }
        
        return set.size();
    }
	
	private int findGcd(int num, int[] nums) {			
		return gcd(num, findGcd(nums));
	}
	
	private int findGcd(int[] nums, int start, int end) {
		
		int gcd = nums[start];
		while(start < end) {
			gcd = gcd(nums[++start], gcd);
		}
		
		return gcd;
	}
	
	private int findGcd(int[] nums) {
		int end = nums.length-1, gcd = nums[0], i = 0;
		while(i < end) {
			gcd = gcd(nums[++i], gcd);
		}		
		return gcd;
	}
	
	private int gcd(int n1, int n2) {
		if(n1 == 0)
			return n2;
		
		return gcd(n2 % n1, n1);
	}

	int gcd1(int a, int b) {

        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
	
	public static void main(String[] args) {
		// System.out.println(new NumOfDiffSubseqGCDs().gcd(3,6));
		 System.out.println(new NumOfDiffSubseqGCDs().countDifferentSubsequenceGCDs(new int[] {5,15,40,5,6}));

	}
	
	

}
