package com.muks.Algorithm.AlgosOnArrays.Basics;

/**
 * Created by mukthar.ahmed on 5/6/16.
 *
 *  - Longest increasing sub-sequence from an array.
 *
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9, 16};
        //int[] arr = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};

        increasingSubSeq(arr);
    }


    /** ================================================================================
     *  O(n2) solution by simply tracking the consecutive largest element
     */
    private static void increasingSubSeq(int[] arr) {
        int[] table;
        int i;
        int j;
        int max = 0;
        int n = arr.length;
        table = new int[n];


        /** Initialize LIS values for all indexes */
        for (i = 0; i < n; i++) {
            table[i] = 1;
        }

        /** Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {

                if (arr[i] > arr[j] && table[i] < table[j] + 1) {
                    table[i] = table[j] + 1;
                }
            }
        }

        /** Pick maximum of all LIS values */
        for (i = 0; i < n; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }

        System.out.println("# Size of max increasing sub-sequence = " + max);
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(" " + i);
        }
        System.out.println(sb.toString() + "\n");
    }
}

