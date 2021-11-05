package my.learning.leetcode.bits;

public class CountingBits {

	// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
	// ans[i] is the number of 1's in the binary representation of i.
	// Using Dynamic programming
	/*
	    formula : 1 + dp(n - offset);
		0 - 0000 - 0 
		1 - 0001 - 1 = 1 + dp(1 - 1) = 1 + dp(0) = 1
		2 - 0010 - 1 = 1 + dp(2 - 2) 
		3 - 0011 - 2 = 1 + dp(3 - 2)
		4 - 0100 - 1 = 1 + dp(4 - 4) and so on....
	*/
	 public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int offset = 1;
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            if(i == 2*offset)
                offset = 2 * offset;
            
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
	 
	public int[] countBits1(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i] = numberOf1Bits(i);
        }
        return ans;
    }
    
    private int numberOf1Bits(int n){
        int count = 0;
        while(n != 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
