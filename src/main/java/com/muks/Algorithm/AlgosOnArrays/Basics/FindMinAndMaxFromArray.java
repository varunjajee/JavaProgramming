package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.ArrayList;
import java.util.List;


public class FindMinAndMaxFromArray {

	/**
	 * return minimum and maximum in an array. You program should make minimum number of comparisons.
	 */
	public int[] mylist = {2};
	
	public static void main(String[] args) {
		FindMinAndMaxFromArray m = new FindMinAndMaxFromArray();
		int[] arr = {1000, 11, 445, 1, 330, 3000};

		List<Integer> minmax = m.getMinMax(arr, 0, arr.length-1);
		System.out.println("+ min: " + minmax.get(0) + " max: " + minmax.get(1));

	}


	// ################################################################################################################
	// Find the max and min by recursion
	public List<Integer> getMinMax(int arr[], int low, int high) {
		int mid, min = 0, max = 0;
		List<Integer> mylist = new ArrayList<Integer>();

		if(low == high) {
			min = max = arr[low];

			mylist.add(min);
			mylist.add(max);

			return mylist;
		}

		/* If there are two elements */
		if(high == low + 1) {
			if(arr[low] > arr[high]) {
				max = arr[low];
				min = arr[high];

			} else {
				max = arr[high];
				min = arr[low];
			}

			mylist.add(min);
			mylist.add(max);

			return mylist;
		}


		/* If there are more than 2 elements */
		mid = (low + high)/2;  
		List<Integer> mml = getMinMax(arr, low, mid);
		List<Integer> mmr = getMinMax(arr, mid+1, high);  

		/* compare minimums of two parts*/
		if(mml.get(0) < mmr.get(0)) {
			min = mml.get(0);
		} else {
			min = mmr.get(0);
		}

		/* compare maximums of two parts*/
		if(mml.get(1) > mmr.get(1)) {
			max = mml.get(1);
		} else {
			max = mmr.get(1);
		}

		mylist.add(min);
		mylist.add(max);

		return mylist;

	}

}
