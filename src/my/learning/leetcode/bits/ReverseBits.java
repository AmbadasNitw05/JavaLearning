package my.learning.leetcode.bits;

public class ReverseBits {
	
	// Reverse bits of a given 32 bits unsigned integer.
	public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            int bit = (n>>i)&1; // get the bit at position i
            res = res | (bit<<(31-i)); // set the bit at 32 - i position
        }
        
        return res;
    }
	
	public int reverseBits2(int n) {
        return Integer.reverse(n);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
