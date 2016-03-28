package com.muks.Algorithm.AlgosOnArrays;

import java.util.Arrays;

public class MatrixTransposeOrRotate {
	
	public static void main(String[] args) {

		// create N-by-N matrix
		int[][] a = {
				{ 0, 2, 3 },
				{ 4, 1, 6 },
				{ 7, 8, 9 }
		};

		int[][] m =  {
				{1, 1, 1, 1},
				{2, 4, 8, 16},
				{3, 9, 27, 81},
				{4, 16, 64, 256},
				{5, 25, 125, 625}
		};
		
		rotateArbitary(m);		//  rotate an arbitary matrix 
		
		//inplaceRotateAroundDiagonal(a, a.length);		// rotates matrix around the diagonal elements
		
//		int[][] b = RotateMatrixBy90degrees(a, a.length);
//		printMatrix(b);
		
	}

	// ##########################################################################################
	// rotate matrix around the diagonal elements
	public static void inplaceRotateAroundDiagonal (int[][] a, int n) {

		// transpose in-place
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

		// print out transposed matrix
		System.out.println("\nAfter");
		System.out.println("------");
		printMatrix(a);

	}	// rotateAroundDiagonal()
	
	
	// ##########################################################################################
	// rotate
	public static int[][] RotateMatrixBy90degrees(int[][] matrix, int n) {
	    int[][] ret = new int[n][n];

	    for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < n; ++j) {
	            ret[i][j] = matrix[n - j - 1][i];
	        }
	    }

	    return ret;
	}
	
	
	// ###################################################################################################
	public static void rotateArbitary (int[][] m) {
		
		System.out.println("+ in-Col: " + m[0].length + " in-Rows: " + m.length);
		
		int tCols = m[0].length;	// way to get column count
		int tRows = m.length;		// way to get row count
		
		int[][] ans = new int[tCols][tRows];

		for(int i = 0; i < tRows; i++){
			for(int j = 0; j < tCols; j++){
				ans[j][i] = m[i][j];				
			}
		}
		

		for(int[] i:ans){//2D arrays are arrays of arrays
			System.out.println(Arrays.toString(i));
		}
	}
	
	
	// ####################################################################################################
	// Print the entire matrix:
	public static void printMatrix (int[][] matrix) {
		int n = matrix.length;
		System.out.println("\n+ Lenght of the matrix: " + n + "\n & the matrix is => ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("");
	} // printMatrix()
	

}	// end class
