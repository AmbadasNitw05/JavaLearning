package my.learning.hackerrank;

import java.util.Scanner;

public class Palindrome {
	// Given a string s, determine if it is a palindrome, considering only alphanumeric characters 
	// and ignoring cases.
	
	// Shorter way of finding palindrome
	public boolean isPalindrome2(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
	
	// Optimized way
	public boolean isPalindrome(String s) {
		int len = s.length();
        int i=0, j=len-1;
        while(i < j) {
        	while(i<len && !Character.isLetterOrDigit(s.charAt(i))) i++;
        	while(j>=0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
        	if(i<len && j>=0 && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) 
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
	
	// another Optimized way
	public boolean isPalindrome4(String s) {
		int len = s.length();
        int i=0, j=len-1;
        while(i < j) {
        	if(!Character.isLetterOrDigit(s.charAt(i))) i++;
        	else if(!Character.isLetterOrDigit(s.charAt(j))) j--;
        	else if(Character.toUpperCase(s.charAt(i++)) != Character.toUpperCase(s.charAt(j--))) 
        		return false;
  
        }
        return true;
    }
	
	// More optimized way
	public boolean isPalindrome3(String s) {
		char[] charMap = new char[256];
        for (int i = 0; i < 10; i++)
            charMap['0'+i] = (char) (1+i);  // numeric - don't use 0 as it's reserved for illegal chars
        for (int i = 0; i < 26; i++)
            charMap['a'+i] = charMap['A'+i] = (char) (11+i);  //alphabetic, ignore cases, continue from 11
        
        for (int start = 0, end = s.length()-1; start < end;) {
            if (charMap[s.charAt(start)] == 0)
                start++;
            else if (charMap[s.charAt(end)] == 0)
                end--;
            else if (charMap[s.charAt(start++)] != charMap[s.charAt(end--)])
                return false;
        }
        return true;
    }

	public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        int len = A.length(), start = 0, end = len-1;
        while(start < end) {
        	if(A.charAt(start) != A.charAt(end)) {
        		System.out.println("No");
        		return;
        	}
        	start++;
        	end--;
        }
        
        System.out.println("Yes");
        
    }

}
