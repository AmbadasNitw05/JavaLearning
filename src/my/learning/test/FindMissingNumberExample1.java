package my.learning.test;

public class FindMissingNumberExample1 {

	public static void main(String[] args) {
		int[] nums = {1,4,3,2,6};
		System.out.println(FindMissingNumberExample1.getMissingNumberLogic1(nums));
		System.out.println(FindMissingNumberExample1.getMissingNumberLogic2(nums));
	}
	
	public static int getMissingNumberLogic1(int[] arr) {
		int sumOfFirstNNums = arr.length+1+arr.length;
		int actualSumOfArr = 0;
		for(int i=0;i<arr.length;i++) {
			actualSumOfArr+=arr[i];
			sumOfFirstNNums+=i;
		}
		return sumOfFirstNNums-actualSumOfArr;
	}
	
	public static int getMissingNumberLogic2(int[] arr) {
		int n = arr.length + 1;
		int sumOfFirstNNums = n*(n+1)/2;
		int actualSumOfArr = 0;
		for(int i=0;i<arr.length;i++) {
			actualSumOfArr+=arr[i];
		}
		return sumOfFirstNNums-actualSumOfArr;
	}

}
