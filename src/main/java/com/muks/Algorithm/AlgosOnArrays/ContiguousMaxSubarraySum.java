package com.muks.Algorithm.AlgosOnArrays;

public class ContiguousMaxSubarraySum {

	/* Problem Defination:
	 * -------------------
	 * You are given a one dimensional array that may contain both positive and negative integers, 
	 * find the sum of contiguous subarray of numbers which has the largest sum.
	 * For example, if the given array is {-2, -5, "6", "-2", "-3", "1", "5", -6}, then the maximum subarray sum is 7 
	 * (see highlighted elements).
	 */
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 7};
		//int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
		
		System.out.println("+++ Output: " + maxSubArraySum(arr, 0, arr.length-1) );

	} 	// main()
	
	// #########################################################################################################
	// Returns sum of maxium sum subarray in aa[l..h]
	public static int maxSubArraySum(int arr[], int l, int h) {
	   // Base Case: Only one element
	   if (l == h) {
	     return arr[l];
	   }
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h));
	}
	
	
	// #########################################################################################################
	// Find the maximum possible sum in arr[] auch that arr[m] is part of it
	public static int maxCrossingSum(int arr[], int l, int m, int h) {
	    
		// Include elements on left of mid.
	    int left_sum = 0;
	    for (int i = m; i >= l; i--) {
	    	left_sum += arr[i];
	    }
        System.out.println("+++ => " + left_sum );
	 
	    // Include elements on right of mid
	    int right_sum = 0;
	    for (int i = m+1; i <= h; i++) {
	        right_sum += arr[i];
//	        if (sum > right_sum) {
//	        	right_sum = sum;
//	        }
	    }
	 
	    // Return sum of elements on left and right of mid
	    System.out.println("left_sum + right_sum => " + left_sum + " " + right_sum);
	    return left_sum + right_sum;
	}
	
	
	// #########################################################################################################
	// A utility funtion to find maximum of two integers
	public static int max(int a, int b) { 
		int m = (a > b)? a : b;
		return m;
	}
	
	// #########################################################################################################	 
	// A utility funtion to find maximum of three integers
	public static int max(int a, int b, int c) { 
		int m = max(max(a, b), c);
		return m;
	}

}	// end class
