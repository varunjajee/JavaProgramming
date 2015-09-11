package com.muks.algo.AlgosOnArrays;

public class ContiguousSumOfContiguousSubarray {

	/* program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
	 * 
	 * Explanation: (http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/)
	 * Simple idea of the "Kadane's algorithm" is to look for all positive contiguous segments of 
	 * the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment 
	 * among all positive segments (max_so_far is used for this). 
	 * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
	 */

	// http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3, 3, 4};
		//int[] a = {2, 3, 4, 5, 7};


		int maxSumSubarray = kadane(a, 0, a.length-1, a.length-1);
		System.out.println("+ Max Sum from Subarray: " + maxSumSubarray);

		//		int n = a.length-1;
		//		int max_sum = maxSubArraySum(a, n);
		//		System.out.println("Maximum contiguous sum is %d\n" +  max_sum);


	}

	// ################################################################################################
	// Kadane's algo to find the max sum from a 1 dimensional subarray:
	public static int kadane(int[] arr, int start, int finish, int n) {
		// initialize sum, maxSum and start
		int sum = 0, maxSum = 0;

		// needed if sum NEVER becomes less than 0
		start = 0;

		// Standard Kadane's algorithm. See following link
		// http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
		for (int i = 0; i < n; ++i) {
			sum += arr[i];

			if (sum < 0) {
				sum = 0;
				start = i+1;

			} else if (sum > maxSum) {
				maxSum = sum;
				finish = i;
			}
			
		}
		System.out.println("+ max-sum: " + maxSum + " Start: " + start + " Finish: " + finish);
		return maxSum;
	}


	// #############################################################################################
	// Kadane's algorithm to find the sum of a sub-array
	public static int maxSubArraySum(int a[], int size) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for(int i = 0; i < size; i++) {
			max_ending_here += a[i];
			System.out.println(" + max_so_far: " + max_so_far + " + max_ending_here: " + max_ending_here);
			if(max_ending_here < 0) {
				max_ending_here = 0;
			}

			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
			System.out.println(" + max_so_far: " + max_so_far + " + max_ending_here: " + max_ending_here + "\n");
		}

		return max_so_far;
	} 


}
