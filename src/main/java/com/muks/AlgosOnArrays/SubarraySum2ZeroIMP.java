package com.muks.AlgosOnArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarraySum2ZeroIMP {

	/**
	 * Q: Find a sub array from a array which sums to 0
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, -1, 4, -4};
		List<int[]> res = zeroSubarrays(arr);
		
		for (int[] a : res) {
			printArray(a);
		}
		
	}	// main()

	
	// ###################################################################################################
	// generate sub arrays with sum of elements equal to zero
	public static List<int[]> zeroSubarrays( int[] arr ){

		List<int[]> subarrays = new ArrayList<int[]>();		

		for( int i = 0; i < arr.length; i++ ){

			int sum = 0;
			for( int j = i; j < arr.length; j++ ){
				sum += arr[j];
				
				if( sum == 0 ){
					printArray(Arrays.copyOfRange(arr, i, j+1));
					subarrays.add(Arrays.copyOfRange(arr, i, j+1));
				}
			}
		}

		return subarrays;		
	}

	
	
	public static void printArray(int[] arr) {
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println(s);
	}
}	// end class()
