package com.muks.algo.AlgosOnArrays;

public class MaxDifference {

	/*
	 * Given an array arr[] of integers, find out the difference between any two elements such that 
	 * larger element appears after the smaller number in arr[].
	 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
	 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
	 * 
	 * Method 2 (Tricky and Efficient):
	 * Complexity:
	 * -----------
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(1)
	 * 
	 * Flow:
	 * -----
	 * In this method, instead of taking difference of the picked element with every other element, 
	 * we take the difference with the minimum element found so far. So we need to keep track of 2 things:
	 * 1) Maximum difference found so far (max_diff).
	 * 2) Minmum number visited so far (min_element).
	 */

	public static void main(String[] args) {
		int[] arr = { 7, 9, 5, 6, 3, 2 };
		System.out.println("+++ Max diff: " + maxDiff(arr, arr.length-1));

	}


	// ####################################################################################################
	// 
	public static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		
		for(int i = 1; i < arr_size; i++) {       
			if (arr[i] - min_element > max_diff) {
				max_diff = arr[i] - min_element;
				System.out.println("+ min-ele: " + min_element + " max-diff: " + max_diff + " i: " + i);
			}
				
			if (arr[i] < min_element) {
				min_element = arr[i]; 
			}
			
			System.out.println("+ min-ele: " + min_element + " max-diff: " + max_diff + " i: " + i);
			
		}
		return max_diff;
	}


}	// class{}
