package my.learning.leetcode.backtracking;

public class MazeProblem {
	
	private int[][] mazeTable;
	private int[][] solutionTable;
	private int mazeSize;
	
	public MazeProblem(int[][] mazeTable) {
		this.mazeTable = mazeTable;
		this.mazeSize = mazeTable.length;
		this.solutionTable = new int[this.mazeSize][this.mazeSize];
	}
	
	public void solve() {
		if(isPossible(0, 0)) {
			printPath();
		}else {
			System.out.println("Not possible...");
		}
	}

	private boolean isPossible(int x, int y) {
		if(isFinished(x, y))
			return true;
		
		if(isValid(x, y)) {
			this.solutionTable[x][y] = 1;
			
			if(isPossible(x+1, y)) // right direction
				return true;
			
			if(isPossible(x, y+1)) // downward
				return true;
			
			if(isPossible(x-1, y)) // left side
				return true;
			
			if(isPossible(x, y-1)) // upward
				return true;
			
			this.solutionTable[x][y] = 0;
				
		}
		return false;
	}

	private boolean isFinished(int x, int y) {
		if(x == this.mazeSize-1 && y == this.mazeSize-1) {
			this.solutionTable[x][y] = 1;
			return true;
		}
		return false;
	}

	private boolean isValid(int x, int y) {
		if(x<0 || x>=this.mazeSize) return false;
		if(y<0 || y>=this.mazeSize) return false;
		if(this.mazeTable[x][y] != 1) return false;
		if(this.solutionTable[x][y] == 1) return false;
		return true;
	}

	private void printPath() {
		for(int i=0; i<this.mazeSize; i++) {
			for(int j=0; j<this.mazeSize; j++) {
				if(this.solutionTable[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mazeTable = {
				{1, 1, 1, 1, 0},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 1},
				{1, 1, 0, 0, 1}, 
				{1, 0, 1, 1, 1}
		};
		
		MazeProblem mp = new MazeProblem(mazeTable);
		mp.solve();

	}

}
