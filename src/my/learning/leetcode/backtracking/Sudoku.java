package my.learning.leetcode.backtracking;

public class Sudoku {
	
	
	private int[][] sudokuTable;
	private int boxSize;
	private int minNum;
	private int maxNum;
	private int boardSize;
	
	public Sudoku(int[][] sudokuTable, int boxSize, int minNum, int maxNum) {
		this.sudokuTable = sudokuTable;
		this.boardSize = sudokuTable.length;
		this.boxSize = boxSize;
		this.minNum = minNum;
		this.maxNum = maxNum;
	}
	
	public void solve() {
		if(isPossible(0, 0))
			printSudokuTable();
		else
			System.out.println("Not possible...");
	}

	private boolean isPossible(int rowIndex, int colIndex) {
		if(rowIndex == this.boardSize && colIndex == this.boardSize-1)
			return true;
		
		if(rowIndex == this.boardSize) {
			rowIndex = 0;
			colIndex++;
		}
		
		if(sudokuTable[rowIndex][colIndex] != 0) {
			return isPossible(rowIndex+1, colIndex);
		}
		
		for(int num=minNum; num<=maxNum; num++) {
			if(isValid(rowIndex, colIndex, num)) {
				sudokuTable[rowIndex][colIndex] = num;
				
				if(isPossible(rowIndex+1, colIndex)) {
					return true;
				}
				
				// BACKTRACKING...
				sudokuTable[rowIndex][colIndex] = 0;
			}
		}
		
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int num) {
		// Row should have unique value
		for(int i=0; i<this.boardSize; i++) {
			if(sudokuTable[rowIndex][i] == num) 
				return false;
		}
		
		// Column should have unique value
		for(int i=0; i<this.boardSize; i++) {
			if(sudokuTable[i][colIndex] == num) 
				return false;
		}
		
		// Box should have unique value
		int boxRowStartIndex = (rowIndex/this.boxSize)*this.boxSize; 
		int boxColStartIndex = (colIndex/this.boxSize)*this.boxSize;
		for(int i=boxRowStartIndex; i<boxRowStartIndex+this.boxSize; i++) {
			for(int j=boxColStartIndex; j<boxColStartIndex+this.boxSize; j++) {
				if(sudokuTable[i][j] == num)
					return false;
			}
		}
		
		return true;
	}

	private void printSudokuTable() {
		for(int i=0; i<this.boardSize; i++) {
			if(i%this.boxSize == 0) 
				System.out.println();
				
			for(int j=0; j<this.boardSize; j++) {
				System.out.print(String.format(
						j%3==0 ? "%1$4s" : "%1$2s", 
						sudokuTable[i][j]));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] sudokuTable = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
				{5, 2, 0, 0, 0, 0, 0, 0, 0},
				{0, 8, 7, 0, 0, 0, 0, 3, 1},
				{0, 0, 3, 0, 1, 0, 0, 8, 0},
				{9, 0, 0, 8, 6, 3, 0, 0, 5},
				{0, 5, 0, 0, 9, 0, 6, 0, 0},
				{1, 3, 0, 0, 0, 0, 2, 5, 0},
				{0, 0, 0, 0, 0, 0, 0, 7, 4},
				{0, 0, 5, 2, 0, 6, 3, 0, 0}
				
		};
		
		Sudoku sudoku = new Sudoku(sudokuTable, 3, 1, 9);
		sudoku.solve();
	}

}
