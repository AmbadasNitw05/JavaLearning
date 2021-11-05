package my.learning.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
        int[] dp = new int[amount+1];        
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }else{
                    break;
                }
            }
        }
        
        return dp[amount] > amount ? -1: dp[amount];
    }
    
    private void quickSort(int[] arr, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int pivot = partition(arr, firstIndex, lastIndex);
            quickSort(arr, firstIndex, pivot-1);
            quickSort(arr, pivot+1, lastIndex);            
            
        }
    }
    
    private int partition(int[] nums, int firstIndex, int lastIndex){
        int pivot = lastIndex;
        while(firstIndex < lastIndex){
            if(nums[firstIndex] > nums[pivot]){
                firstIndex++;
                continue;
            } 
            if(nums[lastIndex] < nums[pivot]){
                lastIndex--;
                continue;
            }
            // swap
            int temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;            
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[firstIndex];
        nums[firstIndex] = temp;
        
        return firstIndex;
    }
    
	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.coinChange(new int[] {186,419,83,408}, 6249));

	}

}
