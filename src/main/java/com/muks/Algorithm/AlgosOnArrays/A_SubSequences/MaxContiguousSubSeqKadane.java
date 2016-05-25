package com.muks.Algorithm.AlgosOnArrays.A_SubSequences;

/**
 * Created by mukthar.ahmed on 5/12/16.
 *
 *  Kadane's algorithm to find - Max sum sub array
 */
public class MaxContiguousSubSeqKadane {


    public static void main(String[] args) {
        int[] arr = {5,  5, 10, 40, 50, 35};
        int[] arr2 = {2, -1, 2, 3, 4, -5};
        int[] arr3 = {3, 2, -5, 10, 7};

        maxSumContiguousKadane(arr2);
    }



    private static void maxSumContiguousKadane(int[] arr) {
        int maxSum = 0;
        int startIndex = 0;
        int maxStartIndexTillNow = 0;
        int endIndex = 0;

        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                startIndex = maxStartIndexTillNow;
                endIndex = i;
            }

            if (currSum < 0) {
                maxStartIndexTillNow = i+1;
                currSum = 0;
            }
        }

        System.out.println("# max sum contiguous start-index = "
            + startIndex
            + ", end-index = " + endIndex);
    }

}
