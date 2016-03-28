package com.muks.Algorithm.AlgosOnArrays;

public class MatrixSubmatrixWithMaxSum {


	public static void main(String[] args) {
		int[][] M = {
				{1, 2, -1, -4, -20},
				{-8, -3, 4, 2, 1},
				{3, 8, 10, 1, 3},
				{-4, -1, 1, 7, -6}
		};

		int[][] resMatrix = findMaximumSubMatrix(M);
		printMatrix(resMatrix);

	}

	// ##################################################################################################
	// Method to reset the ref array
	public static int[][] findMaximumSubMatrix(int[][] matrix){
		int dim = matrix.length;
		System.out.println("\n+++ dim: " + dim);

		//computing the vertical prefix sum for columns
		int[][] ps = new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (j == 0) {
					ps[j][i] = matrix[j][i];

				} else {
					ps[j][i] = matrix[j][i] + ps[j - 1][i];

				}
			}

		}

		printMatrix(ps);

		int maxSum = matrix[0][0];
		int top = 0, left = 0, bottom = 0, right = 0; 

		//Auxiliary variables 
		int[] sum = new int[dim];
		int[] pos = new int[dim];
		int localMax;                        

		for (int i = 0; i < dim; i++) {
			for (int k = i; k < dim; k++) {
				// Kandane over all columns with the i..k rows
				reset(sum);
				reset(pos);
				localMax = 0;

				//we keep track of the position of the max value over each Kandane's execution
				// notice that we do not keep track of the max value, but only its position
				sum[0] = (ps[k][0] - (i==0 ? 0 : ps[i-1][0]) );
				for (int j = 1; j < dim; j++) { 

					if (sum[j-1] > 0) {
						sum[j] = sum[j-1] + ps[k][j] - (i==0 ? 0 : ps[i-1][j]);
						pos[j] = pos[j-1];

					} else {
						sum[j] = ps[k][j] - (i==0 ? 0 : ps[i-1][j]);
						pos[j] = j;
					}

					if (sum[j] > sum[localMax]) {
						localMax = j;
					}
					
				}//Kandane ends here

				System.out.println("+ localMax: " + localMax);
				if (sum[localMax] > maxSum) {
					/* sum[localMax] is the new max value
	                    the corresponding submatrix goes from rows i..k.
	                     and from columns pos[localMax]..localMax
					 */
					maxSum = sum[localMax];
					top = i;
					left = pos[localMax];
					bottom = k;
					right = localMax;
				}      
				
			}
		}

		System.out.println("Max SubMatrix determinant = " + maxSum);
		//composing the required matrix
		int[][] output = new int[bottom - top + 1][right - left + 1];
		for(int i = top, k = 0; i <= bottom; i++, k++){
			for(int j = left, l = 0; j <= right ; j++, l++){                
				output[k][l] = matrix[i][j];
			}
		}

		System.out.println("+++ (Top, Left) => " + "(" + top + ", " + left + ")");
		System.out.println("+++ (bottom, right) => " + "(" + bottom + ", " + right + ")");
		return output;
	}


	// ##################################################################################################
	// utility to print-matrix
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


	// ##################################################################################################
	// Method to reset the ref array
	private static void reset(int[] a) {
		for (int index = 0; index < a.length; index++) {
			a[index] = 0;
		}
	}


}
