package my.learning.leetcode.str;

public class TwoStringAnagram {
	
	/*Minimum Number of Steps to Make Two Strings Anagram

	Given two strings firstString &  secondString, return the minimum number of steps to 
	make secondString an anagram of firstString.  
	In one step you can choose any character of the secondString and replace it with another character.

	An Anagram of a string is a string that contains the same characters 
	with a different (or the same) ordering.

	*/
	
	public static int getMinStepsToMakeAnagrams(String firstString, String secondString) {
		int len = firstString.length();
		if(len != secondString.length()) return -1;
		
		int[] firstArr = new int[256];
		int[] secondArr = new int[256];
		
		for(int i=0; i<len; i++) {
			firstArr[firstString.charAt(i)]++;
			secondArr[secondString.charAt(i)]++;
		}
		
		int minSteps = 0;
		for(int i=0; i<256; i++) {
			minSteps += Math.abs(firstArr[i] - secondArr[i]);
		}
		
		return minSteps/2;
		
	}

	public static void main(String[] args) {
		System.out.println(TwoStringAnagram.getMinStepsToMakeAnagrams("spinddz", "pincefp"));
	}

}
