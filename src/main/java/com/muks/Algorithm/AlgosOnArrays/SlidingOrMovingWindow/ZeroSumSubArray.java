package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubArray {

	/**
	 * Q: Find a sub array from a array which sums to 0
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, -1, 4, -4};
		List<int[]> res = zeroSubarrays(arr);
		for (int[] a : res) {
			printArray(a);
		}

		printZeroSumSubarray(arr);

	}	// main()

	
	/** ================================================================================================== */
	// generate sub arrays with sum of elements equal to zero
	public static List<int[]> zeroSubarrays( int[] arr ){

		List<int[]> subarrays = new ArrayList<>();

		for( int i = 0; i < arr.length; i++ ){

			int sum = arr[i];
			for( int j = i+1; j < arr.length; j++ ){
				sum += arr[j];
				
				if( sum == 0 ){
					printArray(Arrays.copyOfRange(arr, i, j+1));
					subarrays.add(Arrays.copyOfRange(arr, i, j+1));
				}
			}
		}

		return subarrays;		
	}

	// Returns true if arr[] has a subarray with sero sum
	static Boolean printZeroSumSubarray(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || map.get(sum) != null)
				return true;

			// Add sum to hash map
			map.put(sum, i);
		}

		// We reach here only when there is no subarray with 0 sum
		return false;
	}

	public static void printArray(int[] arr) {
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println(s);
	}
}	// end class()
