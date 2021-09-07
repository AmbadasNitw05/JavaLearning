package my.learning.test;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramTwoStringsEqual {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("First String: ");
		String s1 = scanner.nextLine();
		System.out.println("Second String: ");
		String s2 = scanner.nextLine();
		
		scanner.close();
		
		if(s1.length() == s2.length()) {
			char[] s1CharArr = s1.toCharArray();
			char[] s2CharArr = s2.toCharArray();
			
			Arrays.sort(s1CharArr);
			Arrays.sort(s2CharArr);
			
			if(Arrays.equals(s1CharArr, s2CharArr)) {
				System.out.println("Both are anagram to each other");
			}else {
				System.out.println("Both are not anagram to each other");
			}
		}else {
			System.out.println("Both are not anagram to each other");
		}
		
	}
	

}
