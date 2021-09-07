package my.learning.leetcode.bits;

public class PowerOfTwo {

	// slow for some reason
	public boolean isPowerOfTwo4(int n) {
		return (n>0 && (Math.pow(2, 31)%n == 0));
		// or 2 pow 30 = 1073741824
		// return (n>0 && 1073741824%n == 0);
	}
	
	// Using &. n & n-1 == 0 ? then it is power of 2;
	// Simple but not faster
	public boolean isPowerOfTwo3(int n) {
		if(n <= 0) return false;
		return (n&n-1) == 0;
	}
	
	// Recursion
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) return false;
        if(n == 1 || n == 2) return true;
		if(n % 2 == 1) return false;
		return isPowerOfTwo(n / 2);
	}
	
	// Another worst solution
	public boolean isPowerOfTwo1(int n) {
		if(n <= 0) return false;
		if(n == 1) return true;
		int i = 1, x = 1;
		while(i <= 31) {
			x = x << 1;
			if(x == n) return true;
			i++;
		}
		
		return false;
	}
	
	// Worst solution
	public boolean isPowerOfTwo2(int n) {
		if(n <= 0) return false;
        return Integer.bitCount(n) == 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
