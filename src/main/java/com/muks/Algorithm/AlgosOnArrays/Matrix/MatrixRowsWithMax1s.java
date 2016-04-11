package com.muks.Algorithm.AlgosOnArrays.Matrix;

public class MatrixRowsWithMax1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix =  {
				{1, 2, 0, 1},
				{0, 0, 0, 1},
				{0, 1, 1, 1},
				{0, 1, 6, 1},
				{1, 1, 1, 0}
		};
		
		int max1sRowIndex = rowWithMax1s(matrix);
		System.out.println("+++ Row index having max 1s: " + max1sRowIndex);

	}


	/* A function to find the index of first1BinarySearch index of 1 in a boolean array arr[] */
	public static int first(int[] arr, int low, int high) {
		if(high >= low) {

			int mid = low + (high - low)/2;	    // get the middle index   


			if ( ( mid == 0 || arr[mid-1] == 0) && arr[mid] == 1) {	    // check if the element at middle index is first1BinarySearch 1
				return mid;
			}

			// if the element is 0, recur for right side
			else if (arr[mid] == 0)
				return first(arr, (mid + 1), high);

			else // If element is not first1BinarySearch 1, recur for left side
				return first(arr, low, (mid -1));
		}
		return -1;
	}


	// The main function that returns index of row with maximum number of 1s. 
	public static int rowWithMax1s(int[][] mat) {
		int max_row_index = 0, max = -1; // Initialize max values
		
		int cols = mat[0].length;
		int rows = mat.length;
		System.out.println("+++ rows: " + rows);
		// Traverse for each row and count number of 1s by finding the index 
		// of first1BinarySearch 1
		int i, index;
		for (i = 0; i <= cols; i++) {
			
			index = first (mat[i], 0, rows-1);

			if (index != -1 && (rows - index) > max) {
				max = rows - index;
				max_row_index = i;
			}
		}

		return max_row_index;
	}

	public static void printArray(int[] arr) {
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println("+++ array: " + s);
	}

}
