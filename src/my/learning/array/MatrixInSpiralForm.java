package my.learning.array;

public class MatrixInSpiralForm {
	
	public void print(int[][] matrix) {
		print(matrix, 0, matrix[0].length-1, 0, matrix.length-1);
	}
	
	public void print(int[][] matrix, int fc, int lc, int fr, int lr) {
		
		if(fc <= lc || fr <= lr) {
		
			if(fr >= 0)
			for(int i=fc; i<=lc; i++)
				System.out.print(matrix[fr][i] + "  ");
			
			if(lc >= 0)
			for(int i=fr+1; i<=lr; i++)
				System.out.print(matrix[i][lc] + "  ");		
			
			if(lr >= 0 && lr > fr)
			for(int i=lc-1; i>=fc; i--)
				System.out.print(matrix[lr][i] + "  ");
			
			if(fc >= 0 && lc > fc)
			for(int i=lr-1; i>fr; i--)
				System.out.print(matrix[i][fc] + "  ");
			
			print(matrix, fc+1, lc-1, fr+1, lr-1);
		}
	}

	public static void main(String[] args) {
		MatrixInSpiralForm misf = new MatrixInSpiralForm();
		int[][] matrix = {
				{1, 2, 3, 4, 5, 6},
				{7, 8, 9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30}
		};
		misf.print(matrix);

	}

}
