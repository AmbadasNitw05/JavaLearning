package my.learning.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionGroupSort {

	public List<List<Integer>> groupSort(List<Integer> arr){
		
		List<List<Integer>> resultArr = new ArrayList<List<Integer>>();
		
		// 1. sort the list arr 
		Collections.sort(arr);
		
		Map<Integer, Integer> keyFreq = new HashMap<Integer, Integer>();
		
		for(int num: arr) {
			if(keyFreq.containsKey(num)) {
				keyFreq.put(num, keyFreq.get(num)+1);
			}else {
				keyFreq.put(num, 1);
			}
		}
		
		for(int key: keyFreq.keySet()) {
			resultArr.add(Arrays.asList(key, keyFreq.get(key)));
		}
		
		Collections.sort(resultArr, new Comparator<List<Integer>>() {
			public int compare(List<Integer> list1, 
					List<Integer> list2) {
				return list2.get(1) - list1.get(1);
			}
		});
		
		return resultArr;
		
		
	}

	public static void main(String[] args) {
		System.out.println(new SolutionGroupSort().groupSort(Arrays.asList(1,2,3,2,1)));
	}

}
