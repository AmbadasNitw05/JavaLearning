package my.learning.leetcode.array;

public class PrintSubArray {

	public static void printSubArrays(int[] arr, int start, int end) {
		if(end == arr.length) return;
		else if(start > end) 
			printSubArrays(arr, 0, end+1);
		else{
			System.out.print("[");
			for(int i=start; i<end; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.print(arr[end] + "]\n");		
			printSubArrays(arr, start+1, end);
		}
			
		return;
	}
	
	public static void main(String[] args) {
		PrintSubArray.printSubArrays(new int[] {1,2,3, 4}, 0, 0);
	}

}
