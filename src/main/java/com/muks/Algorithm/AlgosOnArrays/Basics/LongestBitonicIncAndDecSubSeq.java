package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/11/16.
 * <p>
 * Get bitonic / monotonic subsequence (which first increases and then decreases)
 */


public class LongestBitonicIncAndDecSubSeq {
    public static void main(String[] args) {
        int[] input = {10, 25, 36, 40, 59, 48, 34, 20, 9};
        //bitonic(input);

        bitonicIncAndDecSubSeq(input);

    }

    private static void bitonicIncAndDecSubSeq(int[] arr) {
        List<Integer> myList = new ArrayList<>();
        int len = arr.length;

        int[] table = new int[arr.length];
        table[0] = 1;

        /** Calculate increasing sub sequence for the 1st half */
        for (int i = 1; i <= len / 2; i++) {
            table[i] = (arr[i] > arr[i - 1]) ? table[i - 1] + 1 : 1;
        }

        /** Calculate decreasing for 2nd half */
        for (int i = len / 2 + 1; i < len; i++) {
            table[i] = (arr[i] < arr[i - 1]) ? table[i - 1] + 1 : 1;
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
}
