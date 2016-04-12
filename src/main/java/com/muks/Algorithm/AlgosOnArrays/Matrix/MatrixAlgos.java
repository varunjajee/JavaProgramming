package com.muks.Algorithm.AlgosOnArrays.Matrix;


import java.util.ArrayList;
import java.util.List;

public class MatrixAlgos {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 0, 2, 3 },
				{ 4, 1, 6 },
				{ 7, 8, 9 }
		};

		int[][] M = {
				{1, 2, -1, -4, -20},
				{-8, -3, 4, 2, 1},
				{3, 8, 10, 1, 3},
				{-4, -1, 1, 7, -6}
		};

		
		// Q1: Find all possible words from the 2D array
		//	Ans: Insert all the chars into a graph and do a breadth indexByBinarySearch search to find words
		char[][] wordMat = {
				{'a', 'f', 'h', 'u', 'n'},
				{'e', 't', 'a', 'i', 'r'},
				{'a', 'e', 'g', 'g', 'o'},
				{'t', 'r', 'm', 'l', 'p'}

		};
		

	}	// main()

	public static void printDiagonalByRecursion (int[][] matrix, int i, int j) {
		int n = matrix.length -1;
		if (i > n && j > n) {
			return;
		}

		System.out.println( matrix[i][j] );
		printDiagonalByRecursion(matrix, i+1, j+1);
	}

	// ####################################################################################################
	// Method to rotate a square matrix
	public static int[][] RotateMatrix(int[][] matrix, int n) {
		int[][] ret = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				ret[i][j] = matrix[n - j - 1][i];
			}
		}

		return ret;
	}


	// ####################################################################################################
	// Printing all diagonal elements...
	public static void printDiagonal (int[][] matrix) {
		int n = matrix.length;
		System.out.println("\n+ Printing diagonal elements..");


		for (int i=0; i < n; i++) {
			System.out.println( matrix[i][n - (i+1)] );
		}

	} // printDiagonal()


	// ####################################################################################################
	// print the diagonal elements from left to right bottom

	public static void printDiagonalLeft2Right (int[][] matrix) {
		int n = matrix.length;
		System.out.println("\n+ Printing diagonal elements..");

		//int j = 0;
		for(int i=0, j=0; i < n; i++, j++) {
			System.out.println(matrix[i][j]);
			//j++;
		}

	}


	// ####################################################################################################
	public static void getSumOfMarix (int[][] matrix, int rows, int cols) {
		int sum = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum += matrix[i][j];
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Sum of all elements is: " + sum);
	}


	// ####################################################################################################
	public static List<String> getMatrixPaths(int[][] matrix){
		System.out.println("\n+ All possible paths in the matrix: ");
		List<String> pathList = new ArrayList<String>();
		if(matrix != null && matrix.length > 0){
			getPaths(matrix, 0,0, "", pathList);
		}
		return pathList;
	}

	public static void getPaths(int[][] matrix, int i, int j, String path, List<String> pathList){

		int n = matrix.length - 1;
		if(i > n || j > n) {
			return;
		} 

		else if ( matrix[i][j] != 1 ) {//only 1 is valid
			path += String.format(" (%d,%d)", i , j);

			if( i == n && j == n) { // reach (n,n) point
				pathList.add(path);

			} else {
				getPaths(matrix, i+1, j , path, pathList);
				getPaths(matrix, i , j+1, path, pathList);
				getPaths(matrix, i + 1 , j+1, path, pathList);

			}
		}
	}

	// ####################################################################################################
	// Find element in matrix by binary search. Note; possible if its a sorted matrix

	// FindInMatrix(matrix, 5, 0, matrix.length-1)

	public static boolean FindInMatrix(int[][] matrix, int x, int row, int col) {
		System.out.println(" & x: " + x );
		if (row > matrix.length-1 || col < 0)
			return false;

		System.out.println(" x > matrix[" + row + "][" + col + "] : " + matrix[row][col]);
		if (x > matrix[row][col]) {
			row++;

		} else if(x < matrix[row][col]) {
			col--;

		}  else {
			return true;

		}

		return FindInMatrix(matrix, x, row, col);

	} // end FindMatrix()


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


	// ####################################################################################################
	//	Max sum in a sub-matrix
	public static int kadane(int[] arr, int start, int finish, int n) {
		// initialize sum, maxSum and start
		int sum = 0, maxSum = 0;

		// needed if sum NEVER becomes less than 0
		start = 0;

		// Standard Kadane's algorithm. See following link
		// http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
		for (int i = 0; i < n; ++i) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
				start = i+1;

			} else if (sum > maxSum) {
				maxSum = sum;
				finish = i;
			}
		}
		System.out.println("+ max-sum: " + maxSum + " Start: " + start + " Finish: " + finish);
		return maxSum;
	}


	



} 	// class - MatrixAlgos()
