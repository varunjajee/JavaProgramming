package com.muks.Algorithm.SearchAlgo;

//import dsc.DictionaryBinarySearch;


public class BinarySearch {
	// EG: Binary search - using divide and conquer design technique/algorithm
	/**
	 * Example for binary search: [1,3,4,5,6,7,8,10,12,14,15,19,22,23,35], using divide and conquer design 
	 * 
	 *  Algorithm BinarySearch(A, k, low, high) {
	 *  	if low > high then return NIL; // if low is high then something is wrong
	 *  	else 
	 *  		mid <- (low + high)/2;
	 *  		if k = A[mid] then return mid
	 *  		else-if k < A[mid] then 
	 *  			return BinarySearch (A, k, low, mid-1);
	 *  		else 
	 *  			return BinarySearch (A, k, mid+1, high);
	 *  }
	 * 
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,8,10,12,14,17,19,22,24,27,28};

		System.out.println("+ Found at the index level = "
				+ BinarySearchRecursive(array, 22, 1, array.length));

		int foundIndex = BinarySearchRecursive(array, 22, 1, array.length);

		System.out.println("+ Testing - array[res-index] = " + array[foundIndex]);
	}

	// NOTE: Complexity = log-n base-2 [ log n] or also written as O(log n), by default it's base 2     		2
	// This is because, for each traverse, the input tends to be half.
	public static int BinarySearchRecursive (int[]arr, int k, int low, int high) {
		if (low > high) {
			return 0;

		} else {
			int mid = low + (high - low)/2;	// low + (high - low)/2
			if (k == arr[mid]) {
				return mid;

			} else if (k < arr[mid]) {
				return BinarySearchRecursive(arr, k, low, mid-1);

			} else {
				return BinarySearchRecursive(arr, k, mid+1, high);

			}

		}

	} // end of BinarySearchRecursive()

}
