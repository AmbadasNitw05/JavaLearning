package my.learning.leetcode.rec;

public class PowerOfThree {

	public boolean isPowerOfThree2(int n) {
        if(n==1 || n==0) return n==1;
        return (n%3==0)&&(isPowerOfThree2(n/3));
    }
	
	public boolean isPowerOfThree1(int n) {
        return (n>0 && Math.pow(3, 19)%n == 0);
    }
	
	// Slow in performance
	public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(n == 1 || n == 3) return true;
        if(n % 3 != 0) return false;        
        return isPowerOfThree(n/3);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
