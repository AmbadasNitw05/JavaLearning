package my.learning.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortArrayByFreq {
	
	// Input: nums = [1,1,2,2,2,3]
	// Output: [3,1,1,2,2,2]
	// Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
	// If multiple values have the same frequency, sort them in decreasing order.
			
	public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums) {
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if(o1.getValue() != o2.getValue())
					return o1.getValue().compareTo(o2.getValue());
				else
					return o2.getKey().compareTo(o1.getKey());
			}
		});
        
        int i=0;
        for(Map.Entry<Integer, Integer> entry: list) {
        	for(int j=0;j<entry.getValue();j++)
        		nums[i++] = entry.getKey();
        }
        
        return nums;
    }
	
	
	
	public int[] frequencySort2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0)+1));
		
		return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a)-map.get(b) : b-a)
			.mapToInt(n -> n)
			.toArray();
	}
	
	/*
 	custom sort explanation:
	.stream(nums)
	iterates through the nums array
	
	.boxed()
	converts each int to Integer object, this is because .sorted() can only operate on objects
	
	.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
	if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by decending numeric value
	
	.mapToInt(n -> n)
	converts Integer to int
	
	.toArray()
	returns array
 */

	public static void main(String[] args) {
		SortArrayByFreq obj = new SortArrayByFreq();
		int[] result = obj.frequencySort2(new int[] {1,1,2,2,2,3});
		for(int num: result)
			System.out.print(num + " ");
	}

}
