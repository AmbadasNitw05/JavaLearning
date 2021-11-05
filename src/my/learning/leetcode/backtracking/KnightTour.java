package my.learning.leetcode.backtracking;

public class KnightTour {

	// See if knight can visit every cell of the chess board only once
	
	private static final int NUM_OF_MOVES = 8;
	
	// chess board size boardSize * boardSize
	private int boardSize;
	private int[][] chessMatrix;
	private int[] xMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
	private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public KnightTour(int boardSize) {
		this.boardSize = boardSize;
		chessMatrix = new int[boardSize][boardSize];
	}
	
	public void solve() {
		this.chessMatrix[0][0] = 1;
		if(isPossible(0, 0, 2))
			printChessMatrix();
		else
			System.out.println("It's not possible...");
	}


	private boolean isPossible(int x, int y, int stepCount) {
		if(stepCount == this.boardSize*this.boardSize+1)
			return true;
		
		for(int i=0; i<NUM_OF_MOVES; i++) {
			
			int nextX = x + this.xMoves[i];
			int nextY = y + this.yMoves[i];
			
			if(isStepValid(nextX, nextY)) {
				chessMatrix[nextX][nextY] = stepCount;
				
				if(isPossible(nextX, nextY, stepCount+1)) {
					return true;
				}
				
				// BACKTRACKING...
				chessMatrix[nextX][nextY] = 0;	
			}
			
		}
		
		return false;
	}


	private boolean isStepValid(int x, int y) {
		if(x < 0 || x >= this.boardSize) return false;
		if(y < 0 || y >= this.boardSize) return false;
		if(this.chessMatrix[x][y] != 0) return false;
		return true;
	}


	private void printChessMatrix() {
		for(int i=0; i<this.boardSize; i++) {
			for(int j=0; j<this.boardSize; j++) {
				System.out.print(String.format("%1$5s", this.chessMatrix[i][j]));
			}
			System.out.println();
		}
		
	}


	public static void main(String[] args) {
		KnightTour kt = new KnightTour(8);
		kt.solve();

	}

}
