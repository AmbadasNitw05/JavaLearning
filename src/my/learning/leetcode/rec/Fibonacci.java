package my.learning.leetcode.rec;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	// recursion + memoization with arr cache -> optimization - fastest
		int[] fibCache = new int[31];
		public int fib(int n) {
	        if(n <= 1) return n;
	        if(fibCache[n] > 0) return fibCache[n];
	        int total =  fib(n-1) + fib(n-2);
	        fibCache[n] = total;
	        return total;
	    }

	// recursion + memoization with map -> optimization
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int fib2(int n) {
        if(n <= 1) return n;
        if(map.containsKey(n)) return map.get(n);
        int total =  fib2(n-1) + fib2(n-2);
        map.put(n, total);
        return total;
    }
	
	// only recursion 
	public int fib1(int n) {
		if(n <= 1) return n;
        return fib1(n-1) + fib1(n-2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
