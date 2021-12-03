package my.learning.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	 public static boolean isPowerofTwo(long n){      
	      
	      if(n <= 0) return false;	      
	      
	      return Long.bitCount(n) == 1;
	 }
	 
	public boolean isPalindrom(int num) {
		int tempNum = num;
		int revNum = 0;
		while(tempNum > 0) {
			revNum = revNum * 10 + tempNum % 10;
			tempNum = tempNum / 10; 
		}
		
		return revNum == num;
	}
	
	// Return the minimum number of deletion of characters 
	// to make the string having unique number of repitations of letters
	// String will have only lower case letters
	
	public int solution3(String S) {
		
		int[] arr = new int[26];
		
		for(int i=0; i<S.length(); i++) {
			arr[S.charAt(i)-'a']++;
		}
		
		Arrays.sort(arr);
		int count = 0;
		for(int i=1; i<26; i++) {
			if(arr[i] != 0) {
				if(arr[i] == arr[i-1]) {
					count++;
				}
			}
		}
		
		return count;
		
		
	}
	
	// Return palindrome that contains of length N and K number of lower-case letters
	
	public String solution(int N, int K) {
        // write your code in Java SE 8
        char[] result = new char[N];
        int mid = N/2;
        int ch = 0;
        
        for(int i=0; i<=mid; i++){
        	if(ch == K) ch = 0;
            result[i] = (char)(97 + ch);
            result[N-1-i] = (char)(97 + ch);
            ch++;
        }

        //if( N%2 == 1) result[mid + 1] = 'a';

        return new String(result);
    }

	 	public int[] solution2(int N) {
	        // write your code in Java SE 8
	 		if(N == 1) {
	 			return new int[] {1 + (int)(Math.random()*10)};
	 		}
	        int[] array = new int[N];
	        for(int i=0;i<N;i++){
	            if(i==0){
	                array[i] = 1+(int) (Math.random()*10);
	            }else {
	            	array[i] = (int) (Math.random()*100);
	            }
	            
	        }
	        return array;
	    }

	    int find_min(int[] A) {
	        int ans = 0;
	        for (int i = 1; i < A.length; i++) {
	            if (ans > A[i]) {
	                ans = A[i];
	            }
	        }
	        return ans;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(new Solution().isPowerofTwo(549755813888L));
		}
}
