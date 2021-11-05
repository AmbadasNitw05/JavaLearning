package my.learning.leetcode.backtracking;

import java.util.Arrays;

public class HamiltonianCycle {
	
	private int[][] adjacencyMatrix;
	private int[] hamiltonianPath; // stores the visited nodes
	private int numOfVertexes;
	
	public HamiltonianCycle(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertexes = adjacencyMatrix.length;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
	}
	
	public void solve() {
		if(findFeasibleSolution(1)) {
			printHamiltonionPath();
		}else {
			System.out.println("No feasible solution...");
		}
	}
	
	private boolean findFeasibleSolution(int position) {
		if(position == numOfVertexes) {
			if(adjacencyMatrix[this.hamiltonianPath[position-1]][this.hamiltonianPath[0]] == 1)
				return true;
			else
				return false;
		}
		
		for(int i=1; i<numOfVertexes; i++) {
			if(isFeasible(i, position)) {				
				hamiltonianPath[position] = i;
				
				if(findFeasibleSolution(position+1)) {
					return true;
				}
			}
			
			// Backtracking
		}
		
		return false;
	}
	
	private boolean isFeasible(int vertexIndex, int actualPosition) {
		// First Criteria: position and actualPosition not connected return false
		if(adjacencyMatrix[hamiltonianPath[actualPosition-1]][vertexIndex] == 0) {
			return false;
		}
		
		// if we already visited return false
		for(int i=0; i<actualPosition; i++) {
			if(hamiltonianPath[i] == vertexIndex)
				return false;
		}
		
		return true;
	}
	
	private void printHamiltonionPath() {
		System.out.println("Hamiltonian cycle path: " + Arrays.toString(this.hamiltonianPath));
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
		
		HamiltonianCycle hc = new HamiltonianCycle(adjacencyMatrix);
		hc.solve();

	}

}
