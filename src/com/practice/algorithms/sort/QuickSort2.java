package com.practice.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
	
	private int[] nums;
	
	public QuickSort2(int[] nums) {
		this.nums = nums;
	}
	
	private int partition(int leftIndex, int rightIndex) {
		int pivot = new Random().nextInt(rightIndex-leftIndex+1) + leftIndex;
		
		swap(pivot, rightIndex);
		
		for(int i=leftIndex; i<rightIndex; i++) {
			if(nums[i] < nums[rightIndex]) {
				swap(i, leftIndex);
				leftIndex++;
			}
		}
		
		swap(leftIndex, rightIndex);
		
		return leftIndex;
		
	}
	
	public void sort() {
		quickSort(0, nums.length-1);
	}
	
	private void quickSort(int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			int pivotIndex = partition(leftIndex, rightIndex);
			
			quickSort(leftIndex, pivotIndex-1);
			quickSort(pivotIndex+1, rightIndex);
		}
	}	
	
	private void swap(int index1, int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
	
	public int[] getNums() {
		return this.nums;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {20, -4, 0, 100, 34, -5, 99, 21, 1, 6};
		QuickSort2 quickSort2 = new QuickSort2(nums);
		quickSort2.sort();
		System.out.println(Arrays.toString(quickSort2.getNums()));

	}

}
