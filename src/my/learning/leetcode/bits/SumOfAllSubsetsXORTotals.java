package my.learning.leetcode.bits;

public class SumOfAllSubsetsXORTotals {
	
	/*
	 * public int subsetXORSum(int[] nums) { int len = nums.length;
	 * 
	 * int i = 0, j = 0;
	 * 
	 * int result = 0; while(j < len && i < len) { result += xORSum(nums, i, j);
	 * if(j == len-1) { i++; j = i; }else j++;
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * }
	 */
	
	static int left = 0, right = 0;
	
    public int subsetXORSum(int[] nums) {
        return getAns(nums,0,0, "left", 0);
    }
    
    int getAns(int[] arr,int i,int cur, String ind, int c){
    	System.out.println(ind + "=" + c + ", i=" + i + ", cur=" + cur);
        if(i==arr.length){
            return cur;
        }
        int leftAns = getAns(arr,i+1,cur^arr[i], "left", ++left);
        System.out.println("leftAns= " + leftAns);
        int rightAns = getAns(arr,i+1,cur, "right", ++right);
        System.out.println("rightAns= " + rightAns);
        
        int res =  leftAns + rightAns;
        System.out.println("res= " + res);
        return res;
    }
    
    // another simple trick 
    int subsetXORSum2(int[] arr) {
        int n = arr.length, res = 0;
        for (int i=0; i < n; ++i)
            res |= arr[i];
        return res * (1 << n-1);
    }
	// 5, 1, 6
    // 0^5 -> 5 ^ 1 -> 4 ^ 6 -> 2 + 4 + 5
	private int xORSum(int[] nums, int start, int end) {
		
		if(start == end) return nums[start];
		
		int result = 0;
		for(int i = start; i<=end; i++) {
			result ^= nums[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		SumOfAllSubsetsXORTotals obj = new SumOfAllSubsetsXORTotals();
		int[] arr = new int[] {5, 1, 6};
		//System.out.println(obj.xORSum(arr, 0, 2));
		System.out.println(obj.subsetXORSum(arr));

	}

}
