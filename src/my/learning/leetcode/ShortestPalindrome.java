package my.learning.leetcode;

public class ShortestPalindrome {

	//You are given a string s. You can convert s to a palindrome by adding characters in front of it.

	// Return the shortest palindrome you can find by performing this transformation.
	
	// Input: s = "aacecaaa"
	// Output: "aaacecaaa"
	
	// Input: s = "abcd"
	// Output: "dcbabcd"

	public String shortestPalindrome(String s) {
        
		int len = s.length();
		
		if(len<=1) return s;
		
		int i=len-1;
		for(;i>=0;i--) {
			if(isPalindrome(s.substring(0,i+1))) break;
		}
		
		String rem = s.substring(i+1,len);
		return new StringBuilder(rem).reverse().toString() + s.substring(0, i+1) + rem;
    }
	
	
	
	private String reverse(String s) {
		if(s.length() <= 1) return s;
		
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
	private boolean isPalindrome(String s) {
		
		int i=0, j=s.length()-1;
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		//System.out.println(new ShortestPalindrome().isPalindrome("abab"));
		System.out.println(new ShortestPalindrome().shortestPalindrome("ababcd"));

	}

}
