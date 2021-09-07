package my.learning.dsa;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		if(len<2) return arr;
		int mid = len/2;
		int[] left = new int[mid];
		int[] right = new int[len-mid];
		
		for(int i=0; i<mid; i++)
			left[i] = arr[i];
		
		for(int j=0;j<len-mid;j++)
			right[j]=arr[mid+j];
		
		return merge(mergeSort(left), mergeSort(right));
		
	}
	
	private static int[] merge(int[] left, int[] right) {
		int leftLen = left.length;
		int rightLen = right.length;
		int[] mergedArr = new int[leftLen + rightLen];
		
		int i=0, j=0, k=0;
		while(i<leftLen && j<rightLen) {
			if(left[i]<right[j]) 
				mergedArr[k]=left[i++];
			else 
				mergedArr[k]=right[j++];
			k++;
		}
		while(i<leftLen) {
			mergedArr[k++]=left[i++];
		}
		while(j<rightLen) {
			mergedArr[k++]=right[j++];
		}
		return mergedArr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {22,13,2,44,55,1,5,7,99,100,33,23,9,10};
		long clock1 = System.currentTimeMillis();
		System.out.println(Arrays.toString(MergeSort.mergeSort(arr)));
		System.out.println("Duration in ms: " + Long.toString(System.currentTimeMillis() - clock1));

	}

}
