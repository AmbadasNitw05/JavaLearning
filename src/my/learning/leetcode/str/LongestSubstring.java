package my.learning.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        int[] cache = new int[256];
        int max = 0;
        for(int i=0, j=0; i<len; i++) {
        	if(cache[s.charAt(i)] > 0) {
        		j = Math.max(j, cache[s.charAt(i)]);
        	}
        	cache[s.charAt(i)] = i+1;
        	max = Math.max(max, i-j+1);
        }
        
        return max;
	}
	
	public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i=0, j=0; i<len; i++) {
        	if(map.containsKey(s.charAt(i))) {
        		j = Math.max(j, map.get(s.charAt(i))+1);
        	}
        	map.put(s.charAt(i), i);
        	max = Math.max(max, i-j+1);
        }
        
        return max;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
	}

}
