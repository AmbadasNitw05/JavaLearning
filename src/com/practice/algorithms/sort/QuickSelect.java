package com.practice.algorithms.sort;

import java.util.Random;

public class QuickSelect {
	
	private int[] nums;
	
	public QuickSelect(int[] nums) {
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
	
	public int kthMin(int k) {
		return quickSelect(0, nums.length-1, k-1);
	}
	
	private int quickSelect(int leftIndex, int rightIndex, int k) {
		
		int pivotIndex = partition(leftIndex, rightIndex);
		
		if(pivotIndex < k)
			return quickSelect(pivotIndex+1, rightIndex, k);
		else if(pivotIndex > k)
			return quickSelect(leftIndex, pivotIndex-1, k);
		
		return nums[pivotIndex];
	}
	
	private void swap(int index1, int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {20, -4, 0, 100, 34, -5, 99, 21, 1, 6};
		QuickSelect quickSelect = new QuickSelect(nums);
		System.out.println(quickSelect.kthMin(4));

	}

}
