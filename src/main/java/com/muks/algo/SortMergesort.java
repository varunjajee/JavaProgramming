package com.muks.algo;

public class SortMergesort {

	public static void main(String[ ] args) {
		final String BLANKS = "  "; // A String of two blanks


		int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };
		int[] sorted = merge_sort(data);
		
		String s = "";
		for (int i : sorted) {
			s += i + " ";
		}
		System.out.println(s);

	}
	


	public static int[] merge_sort(int[] arr) {
		// base case: if lenght of the arr is <= 1 then return arr
		if (arr.length <= 1) {
			return arr;
		}

		int mid = arr.length/2;		// get mid
		int[] left = new int[mid];	// length of left arr => 0-mid
		int[] right;

		// right arr lenght = mid, if len is even else mid+1 if len is odd
		if (arr.length % 2 == 0) {
			right = new int[mid];
		} else {
			right = new int[mid+1];
		}

		int[] results = new int[arr.length];	// resultant array, sorted one having full length

		// keep dividing the array into left and right till the point that 
		// the left and right array hold just one element
		for (int i=0; i < mid; i++) {
			left[i] = arr[i];
		}

		int x=0;
		for (int j=mid; j < arr.length; j++) {
			if (x < right.length) {
				right[x] = arr[j];
				x++;				
			}

		}
		
		left = merge_sort(left);		// recursive statements to keep dividing the array into left and right till the lenght is 1
		right = merge_sort(right);
		
		System.out.println("\n + left: " );
		printArray(left);
		System.out.println("+ right: " );
		printArray(right);
		
		results = merge(left, right);
		System.out.println(" + merged: " );
		printArray(results);
		
		return results;

	}

	
	public static int[] merge (int[] left, int[] right) {
		int lengthRight = left.length + right.length;
		int[] result = new int[lengthRight];
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		while ( indexL < left.length || indexR < right.length ) {
			if ( indexL < left.length && indexR < right.length ) {
				if ( left[indexL] <= right[indexR] ) {
					result[indexRes] = left[indexL];
					indexL++;
					indexRes++;
					
				} else {
					result[indexRes] = right[indexR];
					indexR++;
					indexRes++;
				}
				
			} else if ( indexL < left.length && indexR == right.length) {	// where "right" array is null/finished with sorting
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
				
			} else if ( indexR < right.length && indexL == left.length) {	// where "left" array is null/finished with sorting
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
				
			}
		}
		
		return result;

	}

	
	static void printArray(int[] arr)
	{
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println(s);
	}

}


