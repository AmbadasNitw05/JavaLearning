package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * List<String> list = Arrays.asList("abc","xyz"); System.out.println(list);
		 * String[] arr = list.stream().toArray(n -> new String[n]);
		 * System.out.println(Arrays.toString(arr));
		 */
		
		// sorting map
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m", 3);
		map.put("ab", 2);
		map.put("ac", 1);
		map.put("z", 3);
		map.put("c", 3);
		
		System.out.println("unsorted: " + map);
		Map<String, Integer> result = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sorted: " + result);
		
	}
}
