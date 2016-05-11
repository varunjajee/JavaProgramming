package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/6/16.
 *
 *  - Longest increasing sub-sequence from an array.
 *
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 9, 16};
        int[] arr2 = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};

        increasingSubSeq(arr2);
    }

    /** ================================================================================
     *  O(n2) solution by simply tracking the consecutive largest element
     */

    public static void increasingSubSeq(int[] arr) {
        List<Integer> myList = new ArrayList<>();
        int len = arr.length;

        /** calculate the increasing sub sequence */
        int[] table = new int[arr.length];
        table[0] = 1;

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

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(" " + i);
        }
        System.out.println(sb.toString() + "\n");
    }
}

