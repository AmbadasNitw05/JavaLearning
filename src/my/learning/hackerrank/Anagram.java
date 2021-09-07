package my.learning.hackerrank;

import java.util.Arrays;

public class Anagram {

	static boolean isAnagram(String a, String b) {
		
		if(a.length() != b.length()) return false;
		
        char[] arr1 = a.toUpperCase().toCharArray();
        char[] arr2 = b.toUpperCase().toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

	public static void main(String[] args) {
		System.out.println(Anagram.isAnagram("anagram", "margana"));

	}

}
