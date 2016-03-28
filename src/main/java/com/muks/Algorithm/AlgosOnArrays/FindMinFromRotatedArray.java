package com.muks.Algorithm.AlgosOnArrays;

public class FindMinFromRotatedArray {

	/**
	 * Min and Max is always found at the point of rotation
	 */

	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 1, 2};
		
		findMinInRotated(arr, arr.length);
		
	}	// end main()


	public static void findMinInRotated(int[] arr, int n) {
		
		int rotationalPoint = findPivot(arr, 0, arr.length);
		System.out.println("\n +++ Max: " + arr[rotationalPoint]);
		System.out.println("\n +++ Min: " + arr[rotationalPoint+1]);


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
}
