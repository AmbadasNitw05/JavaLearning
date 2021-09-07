package my.learning.leetcode.rec;

public class PowerOfFour {
	
	// using binary string
	public boolean isPowerOfFour2(int n) {
		if(n <= 0) return false;
		
		String bStr = Integer.toBinaryString(n);
		
		return bStr.matches("^1(00)+$");
	}

	public boolean isPowerOfFour1(int n) {
		return n > 0 && (n&(n - 1)) == 0 && (n & 0x55555555) != 0;
		// return num > 0 && (num&(num-1)) == 0 && (num & 0xAAAAAAAA) == 0;
		
		// 0xAAAAAAAA is 1 at even places in binary form and that will powers of 4
		// 0x55555555 is to get rid of those power of 2 but not power of 4
		// so that the single 1 bit always appears at the odd position
	}

	public boolean isPowerOfFour(int n) {
		if (n == 1 || n == 0)
			return n == 1;
		return (n % 4 == 0) && (isPowerOfFour(n / 4));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
