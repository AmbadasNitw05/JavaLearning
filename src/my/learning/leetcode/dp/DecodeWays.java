package my.learning.leetcode.dp;

import java.util.Arrays;

public class DecodeWays {

	/*
	 * https://www.youtube.com/watch?v=W4rYz-kd-cY
	 * 
	 * case 1: number of i and i-1 between 10 and 26
	 * ways[i] = ways[i-1] + ways[i-2]
	 * 
	 * case 2: number of i and i-1 larger than 26
	 * ways[i] = ways[i-1]
	 * 
	 * case 3: number of i is 0 and i-1 == 1 or 2
	 * ways[i] = ways[i-2]
	 * 
	 * case 4: number of i is 0 and i-1 > 2
	 * stop and return 0;
	 */
	
	// Brute force solution using recursion
	private int helper(String s, int i, int[] cache){
        if(i == 0) {
        	if(s.charAt(i) == '0') {
        		cache[i] = 0;
        		return 0;
        	}
        	else {
        		cache[i] = 1;
        		return 1;
        	}
        }
        
        if(i == -1) return 1;
        
        if(cache[i] != -1)
        	return cache[i];
        
        if(s.charAt(i) == '0') {
        	if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
        		return helper(s, i-2, cache);
        	}
        	else {
        		cache[i] = 0;
        		return 0;
        	}
        		
        }
        
        int ways = 0;
        if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7')
        	ways = helper(s, i-1, cache) + helper(s, i-2, cache);
        else
        	ways = helper(s, i-1, cache);
        
        cache[i] = ways;
        return ways;
    }
    
    public int numDecodings(String s) {
    	int[] cache = new int[s.length()];
    	Arrays.fill(cache, -1);
    	return helper(s, s.length()-1, cache);
    	
    }
	public static void main(String[] args) {
		DecodeWays obj = new DecodeWays();
		System.out.println(obj.numDecodings("10"));

	}

}
