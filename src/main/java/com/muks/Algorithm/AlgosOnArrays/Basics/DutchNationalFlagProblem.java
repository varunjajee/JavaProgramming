package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.Arrays;

/** ####################################################################################
 *
 *  Dutch national flag problem:
 *      - Re-arrange red, white and blue OR
 *      - Re-arrange 1s, 2s and 3s
 */


public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,3,2,2,3,1,1,1,3,2,2,1,1};

		rearrange(arr);
        System.out.println(Arrays.toString(arr));
	}


	public static void rearrange(int[] arr) {
		int i = 0, j = 0;
		int k = arr.length-1;

		while (j <= k) {
			if (arr[j] == 1) {
                swap(arr, i, j);
                i++; j++;
			}

            if (arr[j] == 2) {
                j++;
            }

            if (arr[j] == 3) {
                swap(arr, j, k);
                k--;
            }
		}
	}


	private static void swap(int[] arr, int i, int j) {
		System.out.println("+++ Swapping: i=" + arr[i] + ", j=" + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}	// end class()
