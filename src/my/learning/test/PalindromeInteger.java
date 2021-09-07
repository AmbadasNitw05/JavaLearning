package my.learning.test;

public class PalindromeInteger {
	// optimized solution
public boolean isPalindrome(int x) {
		
		if(x<0 || (x!=0 && x%10 == 0)) return false;
        
        int reverse = 0;
        
        while(reverse < x) {
        	reverse = reverse * 10 + x % 10;
        	x = x / 10;
        }
        
        return (x == reverse || reverse/10 == x);
        
    }

	// ok ok solution
	public boolean isPalindrome2(int x) {
		
        if(x<0 || (x!=0 && x%10 == 0)) return false;
        
        int orig = x;
        int reverse = 0;
        
        while(x != 0) {
        	reverse = reverse * 10 + x % 10;
        	x = x / 10;
        }
        
        return orig == reverse;
        
    }
}
