package com.muks.Algorithm.AlgosOnArrays.A_SubSequences;

/**
 * Created by mukthar.ahmed on 5/12/16.
 *
 *  Max sum non-adjacent sub sequence.
 *
 *  Logic:
 *      int inclusive = max by including current variable
 *      int exclusive = max by excluding current variable,
 *
 *      Return max(incl, excl) out of the loop
 */


public class MaxNonContiguousSubSeq {

    public static void main(String[] args) {
        int[] arr = {5,  5, 10, 40, 50, 35};
        int[] arr2 = {2, -1, 2, 3, 4, -5};
        int[] arr3 = {3, 2, -5, 10, 7};

        maxSumNonAdjacent(arr3);
    }


    /** Dynamic programming logic */
    private static void maxSumNonAdjacent(int[] arr) {
        int incl = arr[0];
        int excl = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(incl, excl + arr[i]);
            excl = temp;
        }

        System.out.println(Math.max(incl, excl));
    }

}