package my.learning.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	 	public int[] solution(int N) {
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
}
