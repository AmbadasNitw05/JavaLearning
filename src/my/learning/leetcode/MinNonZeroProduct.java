package my.learning.leetcode;

public class MinNonZeroProduct {
	
	int MOD = (int)1e9 + 7;
    public int minNonZeroProduct(int p) {
        long max = (long)Math.pow(2, p) - 1;
        long base = max - 1;
        long time = base / 2;
        long res = pow(base, time);
        res = (res * (max % MOD)) % MOD;
        return (int) res;
    }
    
    private long pow(long base, long time) {
        if (time == 0) return 1L;
        long res = 1L;
        long y = pow(base, time / 2) % MOD;
        if (time % 2 == 1) res = (res * base) % MOD;
        res = (res * y) % MOD;
        res = (res * y) % MOD;
        return res;
    }
	

	public static int minNonZeroProduct1(int p) {
		long M = 1_000_000_007; // way to avoid overflow errors. this is prime number too
		long max = ((1L << p)-1L)%M;
		
		long result = (max * pow1(max-1, max/2))%M;
		return (int)result;
	}
	
	// assumption: n is +ve
	private static long pow1(long a, long n) {
		
		if(n == 0) return 1;
		if((n&1) == 0) // even number check
			return pow1(a * a, n/2);
		else
			return a * pow1(a * a, n/2);		
	}

	public static void main(String[] args) {
		System.out.println(new MinNonZeroProduct().minNonZeroProduct(30));
		System.out.println(new MinNonZeroProduct().minNonZeroProduct1(30));
	}

}
