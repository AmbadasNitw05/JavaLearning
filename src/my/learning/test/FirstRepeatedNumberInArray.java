package my.learning.test;

import java.util.ArrayList;
import java.util.List;

public class FirstRepeatedNumberInArray {

	public static void main(String[] args) {
		int[] data = {1,3,3,1,2,7,8,8};
		System.out.println(FirstRepeatedNumberInArray.getFirstRecurringNumberWithList(data));
		
	}
	
	public static Integer getFirstRecurringNumberWithList(int[] data) {
		List<Integer> searchedData = new ArrayList<Integer>();
		for (int value: data) {
			if(searchedData.contains(value)) {
				return value;
			}
			searchedData.add(value);
		}
		return null;
	}
	
	public static Integer getFirstRecurringNumberWithMap(int[] data) {
		List<Integer> searchedData = new ArrayList<Integer>();
		for (int value: data) {
			if(searchedData.contains(value)) {
				return value;
			}
			searchedData.add(value);
		}
		return null;
	}

}
