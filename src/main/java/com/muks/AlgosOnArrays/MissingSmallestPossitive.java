package com.muks.AlgosOnArrays;

import java.util.Arrays;

public class MissingSmallestPossitive {

	public static void main(String[] args) {
		//int[] a = {1,3,4,5,6,7,10};
		int[] arr = {0, 10, 2, -10, -20};
		findMissing(arr, arr.length);

	}

	
	public static int findMissingNum (int[] a) {
		int j = a[0];
		for(int i=0; i<a.length; i++) {
			System.out.println(" + j: " + j + " a[i]: " + a[i]);
			if(j == a[i]) {
				j++;
				continue;

			} else {
				System.out.println(j);
				return j;
//				i--;
//				j++;
//				break;
			}
		}
		return -1;
//		System.out.println("missing numbers are ");
//		for(int r:arr)
//		{
//			System.out.println(" "+r);
//		}

	}


	public static void findMissing (int[] arr, int size) {

		int pArrStart = segregate(arr);
		printArray(arr);

		int[] posSubArray = Arrays.copyOfRange(arr, pArrStart, arr.length);
		int smallest = findMissingNum(posSubArray);
		System.out.println("+ Smallest: " + smallest);
		
	}
	
	
	// ##############################################################################################################
	// Segregate negetive and possitive int
	public static int segregate(int[] arr) {
		int i=0, j=arr.length-1;
		while (i < j) {

			while (arr[i] < 0) {
				i++;
			}

			while (arr[j] > 0) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}

		} // end while()		

		return i;		// return the index  of start of the pos integer sub array

	}

	// ############################################################################################################
	// Swap elements:
	public static void swap (int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];
	}

	// ############################################################################################################
	static void printArray(int[] arr) {
		String s = "";
		for (int x: arr) {
			s += x + " ";
		}
		System.out.println("++ s: " + s);
	}

	// ############################################################################################################

}	// class()
