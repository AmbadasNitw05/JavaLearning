package com.practice.algorithms.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] arr, int firstIndex, int lastIndex) {
		if(firstIndex < lastIndex) {
			int pivot = firstIndex;
			int i = firstIndex;
			int j = lastIndex;
			
			while(i < j) {
				while(arr[i] < arr[pivot] && i < lastIndex)
					i++;
				while(arr[j] > arr[pivot])
					j--;
				
				if(i<j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			int temp = arr[pivot];
			arr[pivot] = arr[j];
			arr[j] = temp;
			quickSort(arr, firstIndex, j-1);
			quickSort(arr, j+1, lastIndex);
			
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {5, 4, 3, 6, 2, 8, 1, 7, 9};
		QuickSort.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

}
