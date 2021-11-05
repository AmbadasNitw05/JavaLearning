package my.learning.leetcode;

public class LongestPalindrome {
	
	//  ababcd 
	
	private int lo, max;
	
	public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;       
       
        for(int i=0; i<len; i++) {
        	extend(s, i, i); // odd ex: aba
        	extend(s, i, i+1); // even ex: baab
        }
        
        return s.substring(lo, max+1);
    }
	
	private void extend(String s, int j, int k) {
		int len = s.length();
		while(j>=0 && k<len && s.charAt(j) == s.charAt(k)){
			j--;
			k++;
		}
		
		j++; k--;
		
		if(k>j && k-j > max-lo) {
			lo = j;
			max = k;
		}
		
	}

	// more time inefficient
	public String longestPalindrome2(String s) {
        int len = s.length();
        if(len <= 1) return s;       
        
        StringBuilder sb = new StringBuilder();
        for(int i=len-1;i>=0;i--){
        	sb.append(s.charAt(i));
        }
        
        String revS = sb.toString();
        String lPal = Character.toString(s.charAt(0));
        int lLen = lPal.length();
        for(int i=0;i<len;i++) {
        	
        	for(int j=i+lLen; j<len && len-j-1 >= 0;) {
        		String subStr = s.substring(i, j+1);
        		if(subStr.equals(revS.substring(len-j-1, len-i))) {
        			lPal = subStr;
        			lLen = subStr.length();
        			j = i + lLen;
        		}else
        			j++;
        	}
        }
        
        return lPal;
        
    }
	
	// palindrome test start from middle testing towards left and right
	public String longestPalindrome3(String s) {
        int len = s.length();
        if(len < 2) return s;
        int maxLen = 0;
        String palindrome = "";
        for(int i=0; i<len; i++){
            // Odd length
            int left = i, right=i;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLen){
                    maxLen = right -left + 1;
                    palindrome = s.substring(left, right+1);                    
                }  
                left--;
                right++;
            }
            
            // even length
            left = i;
            right = i + 1;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxLen){
                    maxLen = right -left + 1;
                    palindrome = s.substring(left, right+1);                    
                }  
                left--;
                right++;
            }
        }
        
        return palindrome;
    }
	
	//  ababcd 
	// dcbaba
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome3("cbbd"));

	}

}
