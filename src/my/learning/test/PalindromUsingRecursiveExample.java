package my.learning.test;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromUsingRecursiveExample {

	// Palindrome => word = reverseWord  Ex: madam
	// Recursive => Calling the same parent method
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		System.out.println(PalindromUsingRecursiveExample.isWordPalindromeWithRecursive(word));
		System.out.println(PalindromUsingRecursiveExample.isWordPalindromeWithCharArr(word));
		System.out.println(PalindromUsingRecursiveExample.isWordPalindromeWithStringBuilder(word));
		scanner.close();
	}
	
	public static boolean isWordPalindromeWithRecursive(String word) {
		String reverseWord = getReverseWord(word);
		System.out.println("reverseWord (using recursive): " + reverseWord);
		if(word.equals(reverseWord)) {
			return true;
		}
		return false;
	}
	
	public static boolean isWordPalindromeWithCharArr(String word) {
		char[] reverseArr = new char[word.length()];
		for(int i=0; i<word.length(); i++) {
			reverseArr[i] = word.charAt(word.length()-1-i);
		}
		String reverseWord = String.valueOf(reverseArr);
		System.out.println("reverseWord (with Char Arr): " + reverseWord);
		if(word.equals(reverseWord)) {
			return true;
		}
		return false;
	}
	
	public static boolean isWordPalindromeWithStringBuilder(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<word.length(); i++) {
			sb.append(word.charAt(word.length()-1-i));
		}
		String reverseWord = sb.toString();
		System.out.println("reverseWord (with StringBuilder): " + reverseWord);
		if(word.equals(reverseWord)) {
			return true;
		}
		return false;
	}
	

	private static String getReverseWord(String word) {
		/*
		 * String reverseWord = null;
		 * 
		 * if(word.length() > 1) { reverseWord = word.substring(word.length()-1,
		 * word.length()); reverseWord = reverseWord + getReverseWord(word.substring(0,
		 * word.length()-1)); // calling reverseWord recursively }else { reverseWord =
		 * word; }
		 * 
		 * return reverseWord;
		 */
		
		if(word == null || word.isEmpty())
			return "";
		
		return word.charAt(word.length()-1) + getReverseWord(word.substring(0, word.length()-1));
	}
}
