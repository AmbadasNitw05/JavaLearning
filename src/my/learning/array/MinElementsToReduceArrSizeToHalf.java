package my.learning.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinElementsToReduceArrSizeToHalf {

	// input: [3,3,3,3,5,5,5,2,2,7] output: 2
	// Minimum numbers of elements to take out to make the size to at least half
	
	// input: [3,3,3,3,3,5,5,2,2,7] output: 1
	// If you remove 3, the size will be half
	
	public static int solution(int[] arr) {
		int len = arr.length;
		
		if(len<=1) return arr.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num: arr) {
			if(map.containsKey(num))
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		
		List<Integer> repCnt = new ArrayList<Integer>();
		
		// Using KeySet
		for(int key: map.keySet()) {
			repCnt.add(map.get(key));
		}
		
		// Using EntrySet
		/*
		 * for(Entry<Integer, Integer> entry: map.entrySet()) {
		 * repCnt.add(entry.getKey()); }
		 */
		
		Collections.sort(repCnt, new Comparator<Integer>() {			
			public int compare(Integer item1, Integer item2) {
				return item2 - item1;
			}		
		});
				
		int numOfElemsRmvd = 0;
		int i=1;
		for(;i<repCnt.size();i++) {
			int remElemsCnt = len - numOfElemsRmvd - repCnt.get(i-1);
			if(remElemsCnt <= len/2) 
				return i;
			else 
				numOfElemsRmvd+=repCnt.get(i-1);
		}
		
		return i;
		
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{1,1,2,3,4};
		System.out.println(MinElementsToReduceArrSizeToHalf.solution(arr));
		System.out.println(new Scanner(System.in).next());
		
	}
}
