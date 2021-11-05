package my.learning.leetcode.dp;

import java.util.List;

public class WordBreak {
	/*
	 * Given a string s and a dictionary of strings wordDict, 
	 * return true if s can be segmented into a space-separated sequence of 
	 * one or more dictionary words.
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        
        for(int i=s.length()-1; i>=0; i--){
            for(String w: wordDict){
                if(i+w.length() <= len && s.substring(i, i+w.length()).equals(w))
                    dp[i] = dp[i + w.length()];
                
                if(dp[i]) break;
                    
            }
        }
        
        return dp[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
