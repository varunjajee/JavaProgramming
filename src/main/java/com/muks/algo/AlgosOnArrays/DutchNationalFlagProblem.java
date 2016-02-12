package com.muks.algo.AlgosOnArrays;

import java.util.Arrays;

/* ####################################################################################
 * 
 * Question: Segregate 1s 2s and 3s from an array - also called dutch national flag problem
 * 
 */


public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1, 3,2,2,3,1,1,1,3,2,2,1,1};

		//DutchNationalFlagProblem.segregate(arr, 2, 2);
		
		sort123s(arr);
		System.out.println(Arrays.toString(arr));

	}

	
	public static void sort123s(int[] arr) {
		int oneAt = 0;
		int threeAt = arr.length-1;
		
		int i = 0;
		while(i <= threeAt) {
			if(arr[i] == 1) {
				swap(arr, i, oneAt);

				if(i == oneAt) {
					System.out.println("+++ i: " + i + " oneAt: " + oneAt);
					i++;
				}
				//i++;
				oneAt++;
			}
			else if(arr[i] == 3) {
				swap(arr, i, threeAt);
				threeAt--;			
			} 
			else {
				i++;
			
			}
		}	
	}

	
	
	private static void swap(int[] arr, int i, int j) {
		System.out.println("+++ Swapping: i=" + arr[i] + ", j=" + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	
	public static void segregate(int[] a, int low, int high) {
		int startIndex = 0;
		int endIndex = a.length - 1;
		int temp;

		int i = 0;
		while (i <= endIndex) {
			if (a[i] < low) {
				temp = a[i];
				a[i] = a[startIndex];
				a[startIndex] = temp;
				i++;
				startIndex++;

			} else if (a[i] > high) {
				temp = a[i];
				a[i] = a[endIndex];
				a[endIndex] = temp;
				endIndex--;
				// do not increment i. We have to revisit this again

			} else {
				i++;

			}

		}	// for()

	}	// segregate()


}	// end class()
