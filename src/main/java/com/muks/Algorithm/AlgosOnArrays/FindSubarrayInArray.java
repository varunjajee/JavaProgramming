package com.muks.Algorithm.AlgosOnArrays;

import java.util.ArrayList;
import java.util.List;

public class FindSubarrayInArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {4, 5};
		int foundIndex = findSubArray(a, b);
		System.out.println("+++ SubArray starts at: " + foundIndex);

	}

	// ##############################################################################################################
	/**
	 * Finds a sub array in a large array
	 * 
	 * @param largeArray
	 * @param subArray
	 * @return index of sub array
	 */
	public static int findSubArray(int[] largeArray, int[] subArray) {
		System.out.println("+ Large len: " + largeArray.length + " subArr: " + subArray.length);
		
		if (largeArray.length == 0 || subArray.length == 0) {	/* If any of the arrays is empty then not found */
			return -1;
		}

		if (subArray.length > largeArray.length) {	/* If subarray is larger than large array then not found */
			return -1;
		}

		List<Integer> foundIndexes = new ArrayList<Integer>();
		for (int i = 0; i < largeArray.length; i++) {

			if (largeArray[i] == subArray[0]) {			/* Check if the next element of large array is the same as the first element of subarray */
				boolean subArrayFound = true;
				
				for (int j = 0; j < subArray.length; j++) {

					if (largeArray.length <= i+j || subArray[j] != largeArray[i+j]) {	/* If outside of large array or elements not equal then leave the loop */
						subArrayFound = false;
						break;
					} else {
						foundIndexes.add(i+j);
					}
				}

				/* Sub array found - return its index */
				if (subArrayFound) {
					System.out.println(foundIndexes.toString()); 
					return i;
				}

			}	// end if()
			
		}	// for()

		/* Return default value */
		return -1;
	}

}
