package com.muks.Algorithm.AlgoBasics;

import java.util.Arrays;
import java.util.HashMap;


public class ArrayElementsEqualsToSum {

	public static void main(String[] args) {
		int[] values = { 15, 1, 3, 4, 2, 8, 7, 8,10 };

        byHashMap(values, 10);
		//byLinearMethod(values, 10);
	}


    /**
     * find 2 integers which sum up to a given sum
     */
    private static void byHashMap (int[]arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j, 0);
        }

        for (int i = 0; i < arr.length -1; i++) {
            int diff = sum - arr[i];

            if ( map.containsKey(diff) ) {
                System.out.println("Integers summing up to - " + sum + ", are " + diff + ", " + arr[i]);
            }
        }

    } // end byHashMap()




	private static void findPair(int[] arr, int sum) {

		Arrays.sort(arr);

		for (int i : arr) {
			System.out.print(" " + i);
		}

		int left = 0;
		int right = arr.length-1;
		while (left < right) {

			if ( (arr[left] + arr[right]) == sum) {
				System.out.println("\n+ Found the pairs: (1) " + arr[left] + " and (2) " +
					arr[right]);
				//return true;
			}
			if ((arr[left] + arr[right]) < sum) {
				left++;
			}
			else {
				right--;
			}
		}

		//return false;

	}



}
