package my.learning.leetcode.bits;

public class SumOfTwoIntegers {

	// return the sum of the two integers without using the operators + and -.
	// Using iterator
	// 1^1 = 0	1^0 = 1	 0^1 = 1  0^0 = 0
	// 0010>>1   =  0100
	public int getSum1(int a, int b) {
        
        while( b != 0){
            int carry = a&b; // provides carries of binary addition
            
            a = a^b; // provides addition without carry
            
            b = carry<<1; // left shift as carries will be applied on left side
            
            // Now a holds addition without carries
            // and b holds carries
            // iterate through loop until carry is zero
        }
        
        return a;
    }
	
	// Using recursive
	public int getSum(int a, int b) {
		return b==0 ? a : getSum(a^b, (a&b)<<1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
