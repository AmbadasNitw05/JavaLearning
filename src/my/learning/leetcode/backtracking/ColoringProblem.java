package my.learning.leetcode.backtracking;

public class ColoringProblem {

	// return the minimum number of colors required for coloring nodes 
	// condition: no two adjacent nodes should have same color
	
	private int numOfVerticies;
	private int numOfColors;
	private int[] colors;
	private int[][] adjacencyMatrix;
	
	public ColoringProblem(int[][] adjacencyMatrix, int numOfColors) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVerticies = adjacencyMatrix.length;
		this.numOfColors = numOfColors;
		this.colors = new int[this.numOfVerticies];
		
	}
	
	public void solve() {
		if(setColor(0)) {
			printColors();
		}else {
			System.out.println("Not feasible...");
		}
	}
	
	private boolean setColor(int nodeIndex) {
		if(nodeIndex == this.numOfVerticies) {
			return true;
		}
		for(int colorIndex=0; colorIndex<this.numOfColors; colorIndex++) {
			if(isColorValid(nodeIndex, colorIndex)) {
				this.colors[nodeIndex] = colorIndex; 
				
				if(setColor(nodeIndex+1)) {
					return true;
				}
				
				// BACKTRACKING...
			}
		}
		return false;
	}

	private boolean isColorValid(int nodeIndex, int colorIndex) {
		for(int i=0; i<this.numOfVerticies; i++) {
			if(this.adjacencyMatrix[nodeIndex][i] == 1 && this.colors[i] == colorIndex)
				return false;
		}
		return true;
	}

	private void printColors() {
		for(int i=0; i<this.numOfVerticies; i++) {
			System.out.println("Node " + (i+1) + " has color index " + this.colors[i]);
		}
	}

	public static void main(String[] args) {
		int[][] adjacencyMatrix = {
				{0, 1, 1, 1, 0, 0},
				{1, 0, 1, 0, 1, 0},
				{1, 1, 1, 1, 0, 1},
				{1, 0, 1, 0, 0, 1},
				{0, 1, 0, 0, 0, 1}, 
				{0, 1, 1, 1, 1, 1}
		};
		/* int[][] adjacencyMatrix = {
				{0, 1, 0},
				{1, 0, 1},
				{0, 1, 0}
		};*/
		
		ColoringProblem cp = new ColoringProblem(adjacencyMatrix, 5);
		cp.solve();

	}

}
