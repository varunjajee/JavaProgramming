package com.muks.Algorithm.AlgosOnArrays.Matrix;

public class TransposeOrRotate {
	
	public static void main(String[] args) {
        int[][] matrix = InputMatrixSets.getBasicMatrix();

        //rotateAroundDiagonalInplace(matrix);

        rotateMatrixClockwise(matrix);
	}

	/** ------------------------------------------------------------------------------------
	 * 		In-Place, rotate around diagonal
 	 */
	private static void rotateAroundDiagonalInplace(int[][] arr) {
		int n = arr.length;
		// transpose in-place
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		PrintingMatrix.printMatrix(arr);
	}


	/** ------------------------------------------------------------------------------------
	 * Rotate matrix by 90 degree
     */
	public static int[][] rotateBy90degrees(int[][] matrix, int n) {
	    int[][] ret = new int[n][n];

	    for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < n; ++j) {
	            ret[i][j] = matrix[n - j - 1][i];
	        }
	    }

	    return ret;
	}


	/** ------------------------------------------------------------------------------------
	 * 		Rotate by clockwise
     */
	private static void rotateMatrixClockwise(int matrix[][]) {
		int n = matrix.length;
		if (n <= 1) {
			return; // nothing to do
		}

		/** OR */
		for (int i = 0; i <= (n-1)/2; i++) {
			for (int j = i; j < n-i-1; j++) {

				System.out.println("Points: [" + i + ", " + j + "]");
				System.out.println("Points: [" + j + ", " + (n - i -1) + "]");
				System.out.println("Points: [" + (n - i -1) + ", " + (n - j -1) + "]");
				System.out.println("Points: [" + (n - j -1) + ", " + i + "]");
				System.out.println("");

				int p1 = matrix[i][j];
				int p2 = matrix[j][n-i-1];
				int p3 = matrix[n-i-1][n-j-1];
				int p4 = matrix[n-j-1][i];

				matrix[j][n-i-1] = p1;
				matrix[n-i-1][n-j-1] = p2;
				matrix[n-j-1][i] = p3;
				matrix[i][j] = p4;
			}
		}
		PrintingMatrix.printMatrix(matrix);
	}


}	// end class
