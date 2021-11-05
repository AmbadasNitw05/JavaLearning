package com.practice.algorithms.sort;

import java.util.Arrays;

public class MergeSort {
	
	// beg - first index
	// end - last index
	// Space complexity: O(n)
	// In place algorithm: No
	// Time complexity: O(n*log n) in 3 cases (worst, average, best)
	public static void mergeSort(int[] arr, int beg, int end) {
		
		if(beg < end) {		
			int mid = (end+beg)/2;			
			mergeSort(arr, beg, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, beg, mid, end);
		}
		
	}
	
	private static void merge(int[] arr, int beg, int mid, int end) {
		int len1 = mid - beg +1, len2 = end - mid;
		if(len1 == 0 || len2 == 0) return ;
		
		int[] leftArr = new int[len1];
		int[] rightArr = new int[len2];
		
		for(int i=0;i<len1;i++) {
			leftArr[i] = arr[beg+i];
		}
		
		for(int i=0;i<len2;i++) {
			rightArr[i] = arr[mid+1+i];
		}
		
		int i=0, j=0, k=beg;
		
		// Key logic for asc or desc
		while(i<len1 && j<len2) {
			if(leftArr[i]<rightArr[j]) {
				arr[k++] = leftArr[i++];
			}else {
				arr[k++] = rightArr[j++];
			}			
		}
		
		while(i<len1) {
			arr[k++] = leftArr[i++];
		}
		
		while(j<len2) {
			arr[k++] = rightArr[j++];
		}
		
	}

	public static void main(String[] args) {
		int[] arr = new int[] {5, 4, 3, 6, 2, 8, 1, 7, 9};
		MergeSort.mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	
	

}
