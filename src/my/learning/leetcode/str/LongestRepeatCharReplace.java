package my.learning.leetcode.str;

public class LongestRepeatCharReplace {
	/*
		You can choose any character of the string and change it to any other uppercase English character. 
		You can perform this operation at most k times.

		Return the length of the longest substring containing the same letter you can get 
		after performing the above operations.
	*/
	// sliding window solution
	public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, maxLen = 0, maxFreq = 0;
        int[] count = new int[26]; // you can use map, array is perform efficient comparing to map
        for(int right=0; right<len; right++){      
        	// Finding maxFreq with current char
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
            // right-left+1 -> current window length
            while(right-left+1-maxFreq > k){
                count[s.charAt(left)-'A']--;
                left++;
            }    
            maxLen = Math.max(maxLen, right-left+1);
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
