package com.muks.AlgosOnArrays;

public class SubArrayWithSum {

	/**
	 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
	 * Examples:
	 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 3
	 * Ouptut: Sum found between indexes 2 and 4
	 * 
	 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
	 * Ouptut: Sum found between indexes 1 and 4
	 * 
	 * Input: arr[] = {1, 4}, sum = 0
	 * Output: No subarray found
	 */

	public static void main(String[] args) {
		int[] arr = { 20, 3, 10, 1, 4, 5};
		int sum = 15;
		//int sum = 33;

		subArraySumEfficient(arr, arr.length, sum);	// efficient algo
		
//		int ret = subArraySum(arr, sum);		// sub optimal algo
//		System.out.println("+ ret: " + ret);

	}

	
	// ################################################################################################
	/* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false.  Also, prints the result 
	 * */
	public static int subArraySumEfficient (int arr[], int n, int sum) {

	    int currSum = arr[0];	// initializing curr_sum
	    int start = 0;
	 
	    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
	       sum, then remove starting element */
	    for (int i = 1; i <= n; i++) {

	    	while (currSum > sum && start < i-1) {	// If curr_sum exceeds the sum, then remove the starting elements
	            currSum = currSum - arr[start];
	            start++;
	        }
	 
	        if (currSum == sum) {						// If curr_sum becomes equal to sum, then return true
	            System.out.println("Sum found between indexes " + start + " and " + (i-1));
	            return 1;
	        }
	        
	        if (i < n) {	// Add this element to curr_sum
	          currSum += arr[i];
	        }
	        
	    }
	 
	    // If we reach here, then no subarray
	    System.out.println("No subarray found");
	    return 0;
	}
	
	// ############################################################################################################
	// Time Complexity: O(n^2) in worst case.
	/* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false.  Also, prints the result 
	 * */
	public static int subArraySum(int arr[], int sum) {
		int n = arr.length-1;
		int curr_sum, i, j;

		// Pick a starting point
		for (i = 0; i < n; i++) {
			curr_sum = arr[i];

			// try all subarrays starting with 'i'
			for (j = i+1; j <= n; j++) {
				System.out.println(curr_sum + " == " + sum + " arr[j]: " + arr[j]);

				if (curr_sum == sum) {
					System.out.println("Sum found between indexes " + i + " and " + (j-1));
					return 1;
				}

				if (curr_sum > sum || j == n) {
					break;
				}

				curr_sum = curr_sum + arr[j];	// keep adding elements to the curr_sum

			}
		}

		System.out.println("No subarray found");
		return 0;
	}

}
