package com.muks.algo.AlgosOnArrays;

public class SubarrayFromArray0and1 {

	/*
	 * Get a sub array having equal number of 0s and 1s
	 */
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 0 , 0, 0, 1};
		subArrWithEqual0and1(arr, arr.length);
		
		printMaxSubarray(arr);

	}


	public static int subArrWithEqual0and1(int[] arr, int n) {
		int maxsize = -1, startindex = 0;  // variables to store result values

		// Create an auxiliary array sunmleft[]. sumleft[i] will be sum of array 
		// elements from arr[0] to arr[i]
		int[] sumleft = new int[n];
		int min, max; // For min and max values in sumleft[]
		int i;

		// Fill sumleft array and get min and max values in it. 
		// Consider 0 values in arr[] as -1
		sumleft[0] = ( (arr[0] == 0) ? -1 : 1 );
		min = arr[0]; max = arr[0];

		for (i=1; i<n; i++) {      
			sumleft[i] = sumleft[i-1] + ((arr[i] == 0)? -1: 1);
			if (sumleft[i] < min) {
				min = sumleft[i];
			}

			if (sumleft[i] > max) {
				max = sumleft[i];
			}
		} // for()


		// Initialize hash table or a Array-Store to track the sum at every level
		int[] arrayStore = new int[max-min+1];
		for (i=0; i < (max-min+1); i++) {
			arrayStore[i] = -1;
		}

		System.out.println("+ sumLeft: ");
		printArray(sumleft);
		System.out.println("+ ArrayStore: ");
		printArray(arrayStore);
		// debug
		System.out.println("\n+ min: " + min + " max: " + max + "\n+ Printing the hash store...");

		printArray(arrayStore);
		for (i=0; i<n; i++) {
			// Case 1: when the subarray starts from index 0
			System.out.println("+ LeftSum[i]: " + sumleft[i]);
			if (sumleft[i] == 0) {
				maxsize = i+1;
				startindex = 0;
			}

			// Case 2: fill hash table value. If already filled, then use it
			int var = sumleft[i] - min;

			if (arrayStore[sumleft[i] - min] == -1) {
				arrayStore[sumleft[i] - min] = i;
				System.out.println("+ sumlef[i]: " + sumleft[i] + " ===  min: " + min + " var: " + var + " i: " + i );

			} else {
				if ( (i - arrayStore[sumleft[i] - min]) > maxsize ) {
					maxsize = i - arrayStore[sumleft[i] - min];
					startindex = arrayStore[sumleft[i] - min] + 1;
					System.out.println("+++ sumlef[i]: " + sumleft[i] + " ===  min: " + min + " var: " + var + " i: " + i );
				}
			}
		}

		System.out.println("\n+ min: " + min + " max: " + max + "\n+ Printing the hash store...");
		System.out.println("\n+++ Print final sumLeft: ");
		printArray(sumleft);
		printArray(arrayStore);

		if ( maxsize == -1 )
			System.out.println("No such subarray");
		else
			System.out.println("\n+++ Start Index:" + startindex + " to End Index: " + (startindex + maxsize-1));

		return maxsize;

	}

	// Complexity: O(n2)
	// This function Prints the starting and ending indexes of the largest subarray 
	// with equal number of 0s and 1s. Also returns the size of such subarray.
	public static int subArrayByBruteForce(int arr[], int n) {
		int sum = 0;
		int maxsize = -1, startindex = 0;

		// Pick a starting point as i
		for (int i = 0; i < n-1; i++) {
			sum = (arr[i] == 0)? -1 : 1;

			// Consider all subarrays starting from i
			for (int j = i+1; j < n; j++) {
				sum += ( (arr[j] == 0)? -1: 1);

				// If this is a 0 sum subarray, then compare it with
				// maximum size subarray calculated so far
				if(sum == 0 && maxsize < j-i+1) {
					maxsize = j - i + 1;
					startindex = i;
				}
			}
		}

		if ( maxsize == -1 )
			System.out.println(("No such subarray"));
		else
			System.out.println(("Start Index: " + startindex + " to End Index: " + (startindex+maxsize-1) ));

		return maxsize;

	}	// subArrayByBruteForce()

	
	// ###############################################################################################################################################
	// O(n) algo again!!!
	
	private static void printMaxSubarray(int[] arr) {
		Integer[] diffMap = new Integer[arr.length * 2 + 1];
		diffMap[arr.length] = -1;
		int sum = 0;
		int maxLength = 0;
		int maxStart = -1;
		int maxEnd = -1;
		
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == 0)
				sum -= 1;
			else
				sum += 1;
			
			Integer prevIndex = diffMap[arr.length + sum];
			if (prevIndex == null) {
				diffMap[arr.length + sum] = i;
				
			} else {
				if (i - prevIndex > maxLength) {
					maxLength = i - prevIndex;
					maxStart = prevIndex + 1;
					maxEnd = i;
				}
			}
		}
		System.out.println("indices (" + maxStart + "," + maxEnd + ")");
		System.out.println("length=" + maxLength);
	}

	public static void printArray(int[] arr) { 
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println("\n+ Array: " + s);
	}

}
