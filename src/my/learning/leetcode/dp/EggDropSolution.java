package my.learning.leetcode.dp;

public class EggDropSolution {

	// Given numOfEggs and numOfFloors
	// Find out the minimum number of drops to find out the critical floor 
	// from where an egg can be broken
	
	private int numOfEggs;
	private int numOfFloors;
	
	private int[][] dpTable;
	
	public EggDropSolution(int numOfEggs, int numOfFloors) {
		this.numOfEggs = numOfEggs;
		this.numOfFloors = numOfFloors;
		this.dpTable = new int[numOfEggs+1][numOfFloors+1];
	}
	
	// min (max (drop(n-1, x-1), drop(n-1, m-x) ))
	// egg breaks after dropping from floor x
	// 
	public int solve() {
		
		// initialize the first column 2 rows to 1
		this.dpTable[0][1] = 1;
		this.dpTable[1][1] = 1;
		
		// initialize the first row 
		for(int i=1; i<=this.numOfFloors; i++) {
			this.dpTable[1][i] = i;
		}
		
		// main logic using the formula if drops from x floor
		for(int e=2; e<=this.numOfEggs; e++) {
			for(int f=1; f<=this.numOfFloors; f++) {
				
				this.dpTable[e][f] = Integer.MAX_VALUE;
				
				for(int x=1; x<=f; x++) {
					int maxDrops = 1 + Math.max(this.dpTable[e-1][x-1], this.dpTable[e][f-x]);
					
					if(maxDrops < this.dpTable[e][f] )
						this.dpTable[e][f] = maxDrops;
				}
			}
		}
		
		printDp();
		
		return this.dpTable[this.numOfEggs][this.numOfFloors];
	}
	
	public void printDp() {
		for(int i=0;i<this.dpTable.length; i++) {
			for(int j=0; j<this.dpTable[0].length; j++) {
				System.out.print(String.format("%3d", this.dpTable[i][j]));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		EggDropSolution eds = new EggDropSolution(2, 10);
		System.out.println();
		System.out.println("Min drops required: " + eds.solve());

	}

}
