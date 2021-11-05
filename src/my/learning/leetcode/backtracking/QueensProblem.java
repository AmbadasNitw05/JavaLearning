package my.learning.leetcode.backtracking;

public class QueensProblem {

	private int[][] chessTable;
	private int numOfQueens;
	
	public QueensProblem(int numOfQueens) {
		this.chessTable = new int[numOfQueens][numOfQueens];
		this.numOfQueens = numOfQueens;
	}
	
	public void solve() {
		if(setQueens(0))
			printQueens();
		else
			System.out.println("No possible solution");
	}
	
	private boolean setQueens(int colIndex) {
		if(colIndex == numOfQueens)
			return true;
		
		for(int rowIndex=0; rowIndex<numOfQueens; rowIndex++) {
			if(isValidPlace(rowIndex, colIndex)) {
				
				chessTable[rowIndex][colIndex] = 1;
				
				if(setQueens(colIndex+1))
					return true;
				
				// Backtracking
				chessTable[rowIndex][colIndex] = 0;
							
						
			}
		}
		
		return false;
	}
	
	private boolean isValidPlace(int rowIndex, int colIndex) {
		for(int i=0; i<colIndex; i++) {
			if(chessTable[rowIndex][i] == 1)
				return false;
		}
		
		for(int i=rowIndex, j=colIndex; i>=0 && j>=0; --i, --j) {
			if(chessTable[i][j] == 1)
				return false;
		}
		
		for(int i=rowIndex, j=colIndex; i<this.numOfQueens && j>=0; i++, j--) {
			if(chessTable[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	private void printQueens() {
		for(int i=0; i<numOfQueens; i++) {
			for(int j=0; j<numOfQueens; j++) {
				if(chessTable[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		QueensProblem qp = new QueensProblem(5);
		qp.solve();

	}

}
