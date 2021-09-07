package my.learning.hackerrank;

import java.util.Scanner;

public class Palindrome {

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
