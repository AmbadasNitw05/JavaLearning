package com.practice.algorithms.sort;

public class MergeSort2 {
	
	private int[] nums;
	private int[] tempArr;
	
	public MergeSort2(int[] nums) {
		this.nums = nums;
		this.tempArr = new int[nums.length];
	}
	
	public void mergeSort(int left, int right) {
		if(left < right) {
			int middle = (left + right)/2;
			
			mergeSort(left, middle);
			mergeSort(middle+1, right);
			merge(left, middle, right);
			
		}
	}

	private void merge(int left, int middle, int right) {
		
		for(int i=left; i<=right; i++) {
			tempArr[i] = nums[i];
		}
		
		int i=left;
		int j=middle+1;
		int k=left;
		
		while(i<=middle && j<=right) {
			if(tempArr[i] < tempArr[j]) {
				nums[k] = tempArr[i];
				i++;
			}else {
				nums[k] = tempArr[j];
				j++;
			}
			
			k++;
		}
		
		while(i<=middle) {
			nums[k] = tempArr[i];
			i++;
			k++;
		}
		
		while(j<=right) {
			nums[k] = tempArr[j];
			j++;
			k++;
		}
		
	}
	
	public void showResults() {
		for(int num: nums) {
			System.out.print(num + " ");
		}
	}

	public static void main(String[] args) {
		int[] nums = {10, 2, 8, 1, 7, 0, 4, 6, 5, 3, 9};
		MergeSort2 ms2 = new MergeSort2(nums);
		ms2.mergeSort(0, nums.length-1);
		ms2.showResults();
	}

}
