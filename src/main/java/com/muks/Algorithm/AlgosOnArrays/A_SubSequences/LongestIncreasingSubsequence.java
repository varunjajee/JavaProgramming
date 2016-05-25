package com.muks.Algorithm.AlgosOnArrays.A_SubSequences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/6/16.
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9, 16};
        //int[] arr = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};

        increasingSubSeqLength(arr);
        increasingSubSeqElementsAndLength(arr);
    }


    private static void increasingSubSeqLength(int[] arr) {
        List<Integer> myList = new ArrayList<>();
        int len = arr.length;

        int[] table = new int[arr.length];
        table[0] = 1;

        /** Calculate increasing sub sequence for the 1st half */
        for (int i = 1; i < len; i++) {
            table[i] = (arr[i] > arr[i - 1]) ? table[i - 1] + 1 : 1;
        }


        /** Pick maximum of all LIS values */
        int max = table[0];
        for (int i = 1; i < len; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }

        System.out.println("# max = " + max);
    }


    /**
     * ================================================================================
     * O(n2) solution by simply tracking the consecutive largest element
     */
    private static void increasingSubSeqElementsAndLength(int[] arr) {
        int[] table;
        int max = 0;

        table = new int[arr.length];

        List<Integer> myList = new ArrayList<>();
        myList.add(arr[0]);

        /** Calculate increasing sub sequence for the 1st half */
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                table[i] = table[i - 1] + 1;
                if (!myList.contains(arr[i])) {
                    myList.add(arr[i]);
                }
            } else {
                table[i] = 1;
                myList.remove(arr[i]); // remove if not a right candidate
            }
        }


        /** Pick maximum of all LIS values */
        for (int i = 0; i < arr.length; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }

        System.out.println("# Size of max increasing sub-sequence = " + max);
        System.out.println(myList.toString());
    }


}

