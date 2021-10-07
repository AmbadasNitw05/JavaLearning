package my.learning.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMostPickedSweet {

	// if multiple sweets picked equally, return lexographically larger one
	public String getMostPickedSweet(String[] sweets){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int max = 0;
		String maxSweet = "";
		
		for(int i=0;i<sweets.length; i++) {
			map.put(sweets[i], map.getOrDefault(sweets[i], 0)+1);
			if(map.get(sweets[i]) > max) {
				maxSweet = sweets[i];
				max = map.get(sweets[i]);
			}else if(map.get(sweets[i]) == max) {
				if(sweets[i].compareTo(maxSweet) > 0) 
					maxSweet = sweets[i];
			}
		}
		
		return maxSweet;
	}
	public static void main(String[] args) {
		String[] sweets = new String[] {"a","b","c","b","c"};
		System.out.println(new FindMostPickedSweet().getMostPickedSweet(sweets));

	}

}
