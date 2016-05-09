package com.muks.Algorithm.AlgosOnArrays.Basics;

public class FindFromRotatedArray {

	/**
	 * Complexity: O(log n)
	 * Find the index of a "key" from a rotated array...
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		int key = 6;
//		System.out.println("++ Looking for \"" + key + "\"... Found at index: " + pivotedBinarySearch(arr, arr.length, key) );
		
		int foundIndex = searchInRotatedArray(arr, arr.length, key);	// search without pivotal and binary search
		System.out.println("\n+++ Key: " + key + " at index, " + foundIndex);

	}


	// ##################################################################################################################
	// find element in rotated array without pivotal element
	public static int searchInRotatedArray(int[] arr, int n, int key) {
		int start = 0;
		int end = n - 1;

		while (start <= end) {

			int mid = start + (end - start)/ 2;
			if (arr[mid] == key) return mid;

			if (arr[start] <= arr[mid]) {                  /** the bottom half is sorted */
				if (arr[start] <= key && key < arr[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}
			else {                                          /** the upper half is sorted */
				if (arr[mid] < key && key <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}





    /**
     * A lengthy code using find-pivotal, (point of rotation) and then do a binary search
     */
	/* Searches an element no in a pivoted sorted array arrp[]
	of size arr_size */
	public static int pivotedBinarySearch(int arr[], int n, int num) {
		int pivot = findPivot(arr, 0, n-1);

		// If we didn't find a pivot, then array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, n-1, num);

		// If we found a pivot, then first compare with pivot and then
		// search in two subarrays around pivot
		if (arr[pivot] == num) {
			return pivot;
		}

		if (arr[0] <= num) {
			return binarySearch(arr, 0, pivot-1, num);
		} else {
			return binarySearch(arr, pivot+1, n-1, num);
		}
	}

	/* Function to get pivot. For array 3, 4, 5, 6, 1, 2
			   it will return 3 */
	public static int findPivot(int arr[], int low, int high) {
		if (high < low) {
			return -1;
		}

		int mid = low + (high - low)/2;
		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid;
		}

		if (arr[low] >= arr[mid]) {
			return findPivot(arr, low, mid-1);

		} else {
			return findPivot(arr, mid + 1, high);

		}

	}



	/* Standard Binary Search function*/
	public static int binarySearch(int arr[], int low, int high, int num) {
		if (high < low)
			return -1;

		int mid = (low + high)/2;  /*low + (high - low)/2;*/

		if (num == arr[mid]) {
			return mid;
		}

		if (num > arr[mid]) {
			return binarySearch(arr, (mid + 1), high, num);
		} else {
			return binarySearch(arr, low, (mid -1), num);
		}
	}

}
