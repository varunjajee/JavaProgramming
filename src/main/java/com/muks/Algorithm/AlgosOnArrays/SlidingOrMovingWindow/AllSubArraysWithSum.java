package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

import java.util.*;

/**
 * Print all sub arrays with sum
 */
public class    AllSubArraysWithSum {

    public static void main(String[] args) {
        int[] input = {5, 6, 1, -2, -4, 3, 1, 5};
        printSubarrays(input, 5);

//        int[] arr2 = {1, 1, -1, -1};
//        printSubArrayOfRequiredSum(input, 5);
    }

    private static void printSubarrays(int[] input, int k) {
        Map<Integer, List<Integer>> mapIndex = new HashMap<>();

        mapIndex.put(0, new ArrayList<>(Arrays.asList(-1)));
        int preSum = 0;

        for(int i=0; i < input.length; i++) {
            preSum += input[i];
            /** A point where sum = (preSum - k) is present, it means that between that
             point and this, the sum has to equal k */
            if( mapIndex.containsKey(preSum - k) ) {   // Subarray found
                List<Integer> startIndices = mapIndex.get(preSum - k);

                for(int start : startIndices) {
                    System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
                }
            }

            List<Integer> newStartIndices = new ArrayList<>();
            if(mapIndex.containsKey(preSum)) {
                newStartIndices = mapIndex.get(preSum);
            }

            newStartIndices.add(i);
            mapIndex.put(preSum, newStartIndices);
        }
    }


    /**
     *      O(n^2)
     */
    private static void printSubArrayOfRequiredSum(int[] array, int requiredSum) {
        for (int i = 0; i < array.length; i++) {
            String str = "[ ";
            int sum = 0;

            for (int j = i; j < array.length; j++) {
                sum += array[j];
                str += array[j] + ", ";

                if (sum == requiredSum) {
                    System.out.println(" sum : " + sum + " array : " + str + "]");
                    str = "[ ";
                    sum = 0;
                }
            }
        }
    }
}
