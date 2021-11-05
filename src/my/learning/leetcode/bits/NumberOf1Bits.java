package my.learning.leetcode.bits;

public class NumberOf1Bits {

	// you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int counter = 0;
        int mask = 1;
        for(int i=0; i<32; i++){            
            if((n&mask) != 0){
                counter++;
            } 
            
            mask = mask<<1;
        }
        
        return counter;
    }
    
    public int hammingWeight2(int n) {
        int counter = 0;
        while(n != 0){
            n=n&(n-1); // It flips the last right side 1 to zero irrespective of the position
            counter++;
        }
        
        return counter;
    }
    
    // recursive solution
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        return hammingWeight(n&(n-1)) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
