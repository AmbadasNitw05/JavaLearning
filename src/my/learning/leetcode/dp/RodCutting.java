package my.learning.leetcode.dp;

public class RodCutting {

	// Given a rod of length N meters and prices array of each rod of integer length from 1 to N
	// Return the maximum price that can be obtained by cutting the rod into pieces of integer lengths
	
	private int rodLength;
	private int[] prices;
	private int[][] dpTable;
	
	public RodCutting(int rodLength, int[] prices) {
		this.rodLength = rodLength;
		this.prices = prices;
		this.dpTable = new int[prices.length+1][rodLength+1];
	}
	
	public void solve() {
		for(int i=1; i<=this.prices.length; i++) {
			for(int j=1; j<=this.rodLength; j++) {
				int curIndex = i-1;
				if(i<=j) {
					dpTable[i][j] = Math.max(dpTable[i-1][j], this.prices[curIndex] 
							+ dpTable[i-1][j-i]);
				}else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
	}
	
	public void show() {
		System.out.println("Max price: $" + this.dpTable[this.prices.length][this.rodLength] );
		
		for(int r=this.prices.length, c=this.rodLength; r>0;) {
			if(this.dpTable[r][c] != 0 && this.dpTable[r][c] != this.dpTable[r-1][c] ) {
				System.out.println("rod length: " + r + "m");
				c = c - r;
			}else {
				r--;
			}
		}
	}
	public static void main(String[] args) {
		int rodLength = 5;
		int[] prices = {2, 5, 7, 3, 9};
		RodCutting rc = new RodCutting(rodLength, prices);
		rc.solve();
		rc.show();

	}

}
