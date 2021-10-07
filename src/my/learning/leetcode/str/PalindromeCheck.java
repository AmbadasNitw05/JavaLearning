package my.learning.leetcode.str;

public class PalindromeCheck {

	public boolean isPalindrome(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
	}
	
	public boolean isPalindrome1(String s) {
		int len = s.length();
        int i=0, j=len-1;
        while(i < j) {
        	while(i<len && !Character.isLetterOrDigit(s.charAt(i))) i++;
        	while(j>=0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
        	if(i<len && j>=0 && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) 
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
	
		// 48 to 57 -> 0 to 9
		// 65 to 90 -> A to Z
		// 97 to 122 -> a to z
	private static boolean isAlphaNumeric(char ch) {
		if((ch>=48 && ch <= 57) || (ch>=65 && ch <= 90) || (ch>=97 && ch <= 122))
    		return true;    	
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeCheck().isPalindrome("0P"));
	}

}
