package my.learning.leetcode.dp;

public class SubsetSum {

	// given an array of integers and the number N 
	// find out whether sum of the subset of the array can make N
	
	// Ex: {5, 2, 3, 1}, N = 9
	// solution: true because the sum of subset {5, 3, 1} can make 9
	
	private int[] S;
	private int sum;
	
	private boolean[][] dpTable;
	
	public SubsetSum(int[] S, int sum) {
		this.S = S;
		this.sum = sum;
		this.dpTable = new boolean[this.S.length+1][this.sum+1];
	}
	
	public void solve() {
		for(int r=0; r<=S.length; r++) {
			this.dpTable[r][0] = true;
		}
		
		for(int r=1; r<=S.length; r++) {
			for(int c=1; c<=sum; c++) {
				int curIndex = r-1;
				if(c >= S[curIndex]) {
					if(this.dpTable[r-1][c] == true) {
						this.dpTable[r][c] = true;
					}else {
						this.dpTable[r][c] = this.dpTable[r-1][c-S[curIndex]];
					}
				}else {
					this.dpTable[r][c] = this.dpTable[r-1][c];
				}
			}
		}
		
		System.out.println(this.dpTable[this.S.length][this.sum]);
	}
	
	public void show() {
		int c = this.sum;
		int r = this.S.length;
		
		while(c > 0 || r > 0) {
			if(this.dpTable[r][c] == this.dpTable[r-1][c]) {
				r--;
			}else {
				System.out.println("subset element: " + this.S[r-1]);
				c = c - this.S[r-1];
				r--;
			}
		}
	}
	public static void main(String[] args) {
		int[] S = {5, 2, 1, 3};
		int sum = 9;
		SubsetSum ss = new SubsetSum(S, sum);
		ss.solve();
		ss.show();

	}

}
