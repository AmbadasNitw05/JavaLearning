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

	// recursion + memoization with map - top-down approach
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int fib2(int n) {
        if(n <= 1) return n;
        if(map.containsKey(n)) return map.get(n);
        int total =  fib2(n-1) + fib2(n-2);
        map.put(n, total);
        return total;
    }
	
	// tabulation + tabulation with map - bottom-up approach
	public int fib3(int n) {
		Map<Integer, Integer> tMap = new HashMap<Integer, Integer>();
		tMap.put(0, 1);
		tMap.put(1, 1);
		if(n <= 1) return tMap.get(n);
		for(int i=2; i<n; i++)
			tMap.put(i, tMap.get(i-1) + tMap.get(i-2));
		
        
        return tMap.get(n-1);
    }
	
	// using iteration
	public void iter(int n) {
		int a = 1;
		int b = 1;
		for(int i=0; i<n; i++){
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
		int n = 7;
		f.iter(n);
		System.out.println("head recursion (backtrack): " + f.head(n));
		System.out.println("tail recursion: " + f.tail(n, 0, 1));
		System.out.println("recursion+memoization (array cache): " + f.fib(n));
		System.out.println("recursion+memoization (hashmap cache): " + f.fib2(n));
		System.out.println("iteration+tabulation (hashmap cache): " + f.fib3(n));

	}

}
