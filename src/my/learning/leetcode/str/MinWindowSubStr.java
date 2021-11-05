package my.learning.leetcode.str;

public class MinWindowSubStr {
	/*
	 Given two strings s and t of lengths m and n respectively, 
	 return the minimum window substring of s such that every character 
	 in t (including duplicates) is included in the window. 
	 If there is no such substring, return the empty string "".
	 
	 Input: s = "ADOBECODEBANC", t = "ABC"
	 Output: "BANC"
	 Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
	*/
	public static String minWindow(String s, String t) {
        // edge case
        int sLen = s.length(), tLen = t.length();        
        if(tLen > sLen) return "";        
        
        int[] tCache = new int[256];        
        // need
        for(int i=0; i<tLen; i++)
            tCache[t.charAt(i)]++;
        
        int[] sCache = new int[256];
        int resL = 0, minLen = Integer.MAX_VALUE, have = 0, left = 0;
        for(int i=0; i<sLen; i++){
            char ch = s.charAt(i);
            sCache[ch]++;
            
            if(tCache[ch]>0 && tCache[ch] >= sCache[ch])
                have++;
            
            while(have == tLen){
                if(i-left+1 < minLen){
                    resL = left;
                    minLen = i-left+1;
                }
                
                // pop out left char
                ch = s.charAt(left);
                sCache[ch]--;
                if(tCache[ch]>0 && tCache[ch] > sCache[ch]){
                    have--;                    
                }                
                left++;                    
            }            
        }
        
        return minLen < Integer.MAX_VALUE ? s.substring(resL, resL+minLen) : "";
    }
	
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

}
