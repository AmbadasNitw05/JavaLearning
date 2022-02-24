package my.learning.array;

public class BinarySearch {
	
	int binarySearchIter(int[] arr, int n, int k) {
		
		int leftIndex = 0;
		int rightIndex = n - 1;
		while(leftIndex <= rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			
			if(arr[mid] == k) return mid;
			
			if(arr[mid] < k) leftIndex = mid+1;
			else rightIndex = mid-1;
		}
		
		return -1;
	}

	int binarysearch(int arr[], int n, int k){
        return searchRecursive(arr, 0, n-1, k);
    }
    
    int searchRecursive(int[] arr, int left, int right, int val){
        
            if(right < left) return -1;
            
            int mid = (left + right)/2;
            
            if(arr[mid] == val) return mid;
            
            if(arr[mid] < val){
                return searchRecursive(arr, mid, right, val);
            }else{
                return searchRecursive(arr, left, mid, val);
            }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
