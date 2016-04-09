package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

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

        /*int[] arr2 = {1, -1, 4, -4};*/
        int[] arr2 = {1, 1, -1, -1};
        int sum2 = 0;

//		subArraySumEfficient(arr, sum);	// efficient Algorithm
        subArraySumEfficient(arr, sum);	// efficient Algorithm

//		int ret = subArraySum(arr, sum);		// sub optimal Algorithm
	}



	/**
     * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false.  Also, prints the result 
	 * */
	public static int subArraySumEfficient (int arr[], int sum) {
	    int currSum = arr[0];	// initializing curr_sum
	    int start = 0;

	    for (int i = 1; i < arr.length; i++) {
			System.out.println("# Sum = " + currSum + ", Start = " + start + ", i = " + i);
			/** If curr_sum exceeds the sum, then remove the starting elements */
	    	while (currSum > sum && start < i-1) {
	            currSum = currSum - arr[start];
	            start++;
	        }
	 
	        if (currSum == sum) {	/** If curr_sum becomes equal to sum, then return true */
	            System.out.println(currSum + " => Sum found between indexes " + (start) + " and " + (i-1) );

	            return 1;
	        }
	        
	        //if (i < arr.length) {	/** Add this element to curr_sum */
	          currSum += arr[i];
	        //	}
	        
	    }

	    System.out.println("No subarray found");    /** If we reach here, then no subarray */

	    return 0;
	}
	


    public static int subArraySum(int arr[], int sum) {
        int n = arr.length;
        int curr_sum, i, j;

        // Pick a starting point
        for (i = 0; i < n; i++) {
            curr_sum = arr[i];

            // try all subarrays starting with 'i'
            for (j = i+1; j <= n; j++) {
                if (curr_sum == sum) {
                    //System.out.println("Sum found between indexes %d and %d" + i + ", " + j-1);
                    System.out.println("Sum's found between - " + i + ", " + j);

                    return 1;
                }
                if (curr_sum > sum || j == n)
                    break;
                curr_sum = curr_sum + arr[j];
            }
        }

        System.out.println("No subarray found");
        return 0;
    }

}
