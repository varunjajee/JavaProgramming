package com.muks.algo;

import java.util.HashMap;

public class FindNumberSumFromArray {


	public static void main(String[] args) {
		int[] values = { 15, 1, 3, 4, 2, 8, 7,8,10 };
		byHashMap(values, values.length, 10);
		byLinearMethod(values, 10);
	}

	// ##########################################################################################
	/* Since the sorting is binary sorting technique - O(log n)
	 * Then the liner search can go to n in worst case.
	 * Hence - O(n log n), which is said to be done in liner time.
	 * Adv - better than the hash method which extra space is utilized.
	 *  
	 */
	
	public static void byLinearMethod (int[]arr, int sum) {
		QuickSort_DivideAndConquer quickSort = new QuickSort_DivideAndConquer();
		quickSort.quickSort(arr, 0, arr.length-1);

		printMatching(arr, arr.length, 10);

	}

	
	// Get 2 candidate ints summing up to the given value of sum
	public static void printMatching(int array[], int size, int sum)
	{
		int i = 0, j = size - 1;
		int curSum;
		while(i < j) {
			
			curSum = array[i] + array[j];
			if(curSum == sum) {
				System.out.println("Found match at indices %d, %d\n" + array[i] + "," +  array[j]);
				i++;
				j--;
			}
			else if(curSum < sum) {
				i++;
			}
			else {
				j--;
			}
		}
	}


	// Get by hashmap dictionary method - O(n) since we have to walk through all the elements in worst case to initialize the map
	public static void byHashMap (int[]arr, int arraySize, int sum) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int j : arr) {
			map.put(j, 0);
		}


		for (int i = 0; i < arr.length -1; i++) {			
			// when sum - a[i] = diff, if diff and a[i] exists then those are the 2 candidate values
			int tmp = sum - arr[i];

			if ( map.containsKey(tmp)) {
				System.out.println("Two values that add up to {0} are {1} and {2}" + sum + " = " + tmp + ", " + arr[i]);
				//break;
			}
		}

	} // end byHashMap()





}
