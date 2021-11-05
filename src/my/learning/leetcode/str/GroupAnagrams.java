package my.learning.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	/*
	 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	 * 
	 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
	 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 */

	// slow solution
	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
        	// logic: finding common key for anagrams
            char[] cache = new char[26];
            for(char ch: str.toCharArray()){
                cache[ch-'a']++;
            }
            String key = new String(cache);
            // LinkedList faster than ArrayList
            List<String> list = map.getOrDefault(key, new LinkedList<String>());
            list.add(str);
            map.put(key, list);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
	
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}

}
