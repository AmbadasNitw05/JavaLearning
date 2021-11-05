package my.learning.hackerrank;

import java.util.Arrays;

public class Anagram {

	// best solution
	 public static boolean isAnagram(String s, String t) {
        int[] sCache = new int[26];
        int[] tCache = new int[26];
        for(char ch: s.toCharArray())
            sCache[ch-'a']++;
        
        for(char ch: t.toCharArray())
            tCache[ch-'a']++;
        
        for(int i=0; i<26; i++){
            if(sCache[i] != tCache[i])
                return false;
        }
        
        return true;
    }
	 
	// average solution
	static boolean isAnagram2(String s, String t) {
		
		if(s.length() != t.length()) return false;
		
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

	public static void main(String[] args) {
		System.out.println(Anagram.isAnagram("anagram", "margana"));

	}

}
