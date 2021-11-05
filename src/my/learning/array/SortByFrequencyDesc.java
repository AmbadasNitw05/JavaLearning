package my.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortByFrequencyDesc {

	// sort the array or list by the element's frequency in desc order
	// If the element's freq is equal, sort by it's value in asc
	// return 2D array with element as first and it's freq as second
	// Ex: [1,2,1,3,3] -> [[1,2],[3,2],[2,1]]
	// Note: Do not use Collections.sort or Arrays.sort
	public static int[][] sortByFreq(int[] nums) {
		
		return null;
	}
	
	// Using Tree Set
	public static List<List<Integer>> sortByFreq1(List<Integer> nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		nums.stream().forEach(num -> map.put(num, map.getOrDefault(num, 0)+1));
		
		Set<Entry<Integer, Integer>> set = 
				new TreeSet<Map.Entry<Integer,Integer>>((a,b) -> a.getValue() != b.getValue() 
				? b.getValue() - a.getValue() 
				: a.getKey() - b.getKey());
		
		set.addAll(map.entrySet());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		set.stream().forEach(entry -> list.add(Arrays.asList(entry.getKey(), entry.getValue())));
		
			
		return list;
	}
	
	// Using sorted set
	public static List<List<Integer>> sortByFreq2(List<Integer> nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		nums.stream().forEach(num -> map.put(num, map.getOrDefault(num, 0)+1));
		
		SortedSet<Entry<Integer, Integer>> sortedSet = 
				new TreeSet<Map.Entry<Integer,Integer>>((a,b) -> a.getValue() != b.getValue() 
				? b.getValue() - a.getValue() 
				: a.getKey() - b.getKey());
		
		sortedSet.addAll(map.entrySet());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		sortedSet.stream().forEach(entry -> list.add(Arrays.asList(entry.getKey(), entry.getValue())));
		
			
		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,1,3,3,3,2,5,4);
		System.out.println(SortByFrequencyDesc.sortByFreq2(list));
	}

}
