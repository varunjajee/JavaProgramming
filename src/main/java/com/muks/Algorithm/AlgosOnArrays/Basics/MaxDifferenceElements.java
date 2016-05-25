package com.muks.Algorithm.AlgosOnArrays.Basics;

public class MaxDifferenceElements {

	public static void main(String[] args) {
		int[] arr = { 7, 9, 5, 6, 3, 1 };
		System.out.println("+++ Max diff: " + maxDiff(arr, arr.length-1));

	}


	// ####################################################################################################
	// 
	public static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];

		for (int i = 1; i < arr_size; i++) {
			int currDiff = arr[i] - min_element;

            if (currDiff > max_diff) {
				max_diff = currDiff;
			}

			if (arr[i] < min_element) {
				min_element = arr[i];
			}

            System.out.println("# Min=" + min_element + ", Max-Diff=" + max_diff + ", i: " + arr[i]);

		}
		return max_diff;
	}


}	// class{}
