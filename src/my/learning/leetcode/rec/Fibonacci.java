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
	
	// using iteration
	public void iter(int n) {
		int a = 0;
		int b = 1;
		while(a<n) {
			System.out.println(a);
			int temp = a;
			a = b;
			b = temp + a;
			
		}
	}
	
	// head recursion - backtrack
	public int head(int n) {
		if(n <= 1) return n;		
        return head(n-1) + head(n-2);
	}
	
	// tail recursion
	public int tail(int n, int a, int b) {
		if(n==0) return a;
		if(n==1) return b;
		
		return tail(n-1, b, a+b);		
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.iter(7);
		//System.out.println(f.tail(5, 0, 1));

	}

}
