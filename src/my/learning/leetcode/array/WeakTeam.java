package my.learning.leetcode.array;

import java.util.Arrays;

public class WeakTeam {

	// brute force
	public int numberOfWeakCharacters(int[][] properties) {
        
		
		int len = properties.length, weakChar = 0;
		
		Arrays.sort(properties, (a, b) -> b[0] == a[0] ? a[1]-b[1]: b[0]-a[0]);
		
		int max = 0;
		for(int i=0; i<len; i++) {
			if(properties[i][1] < max) {
				weakChar++;
			}
			max = Math.max(max, properties[i][1]);
		}
		
		
		return weakChar;
    }

	public static void main(String[] args) {
		System.out.println(new WeakTeam().numberOfWeakCharacters(new int[][] {{1, 5}, {10, 4}, {10, 3}}));

	}

}
