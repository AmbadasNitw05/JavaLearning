package my.learning.leetcode;

public class StringIndexOf {

	 public int strStr(String haystack, String needle) {
	        
	        
	        
	        int l1 = haystack.length();
	        int l2 = needle.length();
	        
	        if(l2 == 0) return 0;
	        if(l1 < l2) return -1;
	        
	        
	        for(int i=0;i<=l1-l2;i++){
	            if(haystack.substring(i, i+l2).equals(needle))
            		return i;
            	else
            		continue;
	        }
	        
	        return -1;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
