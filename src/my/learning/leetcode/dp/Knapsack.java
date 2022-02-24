package my.learning.leetcode.dp;

public class Knapsack {
	
	// items: 3, weights: {4, 2, 3}, values: {10, 4, 7}, capacity: 5
	// Find out the max benefit (value) by picking up the items such that 
	// the total weight <= capacity (5)
	// max benefit = 11 (picking up item 2nd & 3rd
	
	// Algorithm: Dynamic programming with two-dimensional array
	// rows: items considered, column: capacity, values: max-benefit value at that intersection
	// Find out the max of two values. 1. if considered the item 2. if not considered the item
	// Math.max(table[i-1][w], curVal + table[i-1][w-curWeight])
	// last value in the table is the solution
	
	// inputs
	private int[] weights;
	private int[] values;
	private int capacity;
	
	//required
	private int numOfItems;
	private int[][] table; // items vs capacity
	private int maxBenefit; // solution
	
	public Knapsack(int[] weights, int[] values, int capacity) {
		this.weights = weights;
		this.values = values;
		this.capacity = capacity;
		
		this.numOfItems = this.weights.length;
		this.table = new int[numOfItems+1][capacity+1];
	}
	
	public void solve() {
		for(int i=1; i<=this.numOfItems; i++) {
			for(int w=1; w<=this.capacity; w++) {
				int curItemIndex = i-1;
				int valIfItemNotIncluded = this.table[i-1][w];
				
				int valIfItemIncluded = 0;
				if(this.weights[curItemIndex] <= w) {
					valIfItemIncluded = this.values[curItemIndex] 
							+ this.table[i-1][w-this.weights[curItemIndex]];
				}
				
				this.maxBenefit = Math.max(valIfItemNotIncluded, valIfItemIncluded);
				
				this.table[i][w] = this.maxBenefit;
			}
		}
	}
	
	
	public int solveRec(int m, int w[], int v[], int index) {
		
		// Base condition
		if(m==0 || index<0) return 0;
		
		if(w[index] > m) {
			// not fit 
			return solveRec(m, w, v, index-1);
		}else {
			// fit 
			int excluded = solveRec(m, w, v, index-1);
			int included = v[index] + solveRec(m-w[index], w, v, index-1);
			return Math.max(excluded, included);
		}
	}
	
	public void showResults() {
		System.out.println("Max Profit Value: " + this.maxBenefit);
		
		for(int i=this.numOfItems, w=this.capacity; i>0; i--) {
			if(this.table[i][w] != 0 && this.table[i][w] != this.table[i-1][w]) {
				System.out.println("Item included #" + i);
				w = w - this.weights[i-1];
			}
		}
	}

	public static void main(String[] args) {
		int[] weights = {4, 2, 3};
		int[] values = {10, 4, 7};
		int capacity = 4;
		Knapsack knapsack = new Knapsack(weights, values, capacity);
		knapsack.solve();
		knapsack.showResults();
		System.out.println("Recursive solution: " 
		+ knapsack.solveRec(capacity, weights, values, weights.length-1));

	}

}
