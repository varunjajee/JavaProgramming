package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.Arrays;

public class MedianOfTwoArrays {
	
	/* NOTE: 
	 * 		Time Complexity: O(log n)
			Algorithmic Paradigm: Divide and Conquer
	 */

	public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 6};
		int[] ar2 = {4, 6, 8, 10};
		int n1 = ar1.length;
		int n2 = ar2.length;

		System.out.println("n1: " + n1 + " n2: " + n2);
		if (n1 == n2)
			System.out.println("Median From 2 Arrays: " + getMedianEqLenSortedArrs(ar1, ar2));
		else
			System.out.println("Doesn't work for arrays of unequal size");

	}

	public static int getMedianEqLenSortedArrs (int[] ar1, int[] ar2) {
		//public static int getMedian (int[] ar1, int[] ar2, int n) {
		int m1; /* For median of ar1 */
		int m2; /* For median of ar2 */
		int n = ar1.length;	// lenght of the array (since both the arrays are of same lenght)

		/* return -1  for invalid input */
		if (n <= 0)
			return -1;

		if (n == 1)
			return (ar1[0] + ar2[0])/2;


		if (n == 2) {
			m1 = Math.max(ar1[0], ar2[0]);
			m2 = Math.min(ar1[1], ar2[1]);
			return (m1 + m2) / 2;
		}

		m1 = median(ar1, n); /* get the median of the first array */
		m2 = median(ar2, n);
		System.out.println(" m1: " + m1 + " m2: " + m2);

		int[] subArrA = {};
		int[] subArrB = {};

		/* If medians are equal then return either m1 or m2 */
		if (m1 == m2)
			return m1;


		/* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
		if (m1 < m2) {
			/*	Median of first array is lesser than median of second array
				discard first array's first half as it is definitely less than 
				half of total combined elements
				discard second array's second half as it is definitely greater than 
				half of total combined elements
				recursively determine median in left over array */
			if (n % 2 == 0) {
				//arrays are of even size
				subArrA = Arrays.copyOfRange(ar1, ar1.length/2 - 1, ar1.length);
				subArrB = Arrays.copyOfRange(ar2, 0, ar2.length/2 + 1);
			} else {
				//arrays are of odd size
				subArrA = Arrays.copyOfRange(ar1, ar1.length/2, ar1.length);
				subArrB = Arrays.copyOfRange(ar2, 0, ar2.length/2 + 1);
			}

			return getMedianEqLenSortedArrs(subArrA, subArrB);

		} else {
			//median of first array is greater than median of second array
			//discard first array's second half as it is definitely greater than 
			//half of total combined elements
			//discard second array's first half as it is definitely lesser than 
			//half of total combined elements
			//recursively determine median in left over array

			if (n % 2 == 0) {
				subArrA = Arrays.copyOfRange(ar1, 0, ar1.length/2 + 1);
				subArrB = Arrays.copyOfRange(ar2, ar2.length/2 - 1, ar2.length);
				
			} else {
				//arrays are of odd size
				subArrA = Arrays.copyOfRange(ar1, 0, ar1.length/2 + 1);
				subArrB = Arrays.copyOfRange(ar2, ar2.length/2, ar2.length);
				
			}

			return getMedianEqLenSortedArrs(subArrA, subArrB);
		}

	
} // end getMedianEqLenSortedArrs()


// ##########################################################################################
public static int median(int arr[], int n) {
	if (n % 2 == 0) {
		return (arr[n/2] + arr[n/2-1])/2;
		
	} else {
		System.out.println(" +++++ n: " + n);
		return arr[n/2];
	}

} // end mdeian()

// ##########################################################################################
/**
 * Algorithm:

1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 */
}
