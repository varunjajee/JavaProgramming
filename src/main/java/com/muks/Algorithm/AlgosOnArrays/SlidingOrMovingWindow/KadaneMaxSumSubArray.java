package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

/**
 * Created by mukthar.ahmed on 4/9/16.
 */
class KadaneMaxSumSubArray {
    public static void main(String[] args) {
        //int[] intArr={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
        int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
        //int[] intArr={-6,-2,-3,-4,-1,-5,-5};
        findMaxSubArray(intArr);
    }

    private static void findMaxSubArray(int[] arr) {
        /** holding sub-array, start and end index */
        int startIndex = 0;
        int endIndex = 0;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int maxStartIndexUntilNow = 0;  /** To reset start index, if (maxSum < 0) */

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = maxStartIndexUntilNow;
                endIndex = i;
            }

            else if (sum < 0) {
                maxStartIndexUntilNow = i + 1;
                sum = 0;
            }
        }

        System.out.println("# Max Sum = " + maxSum
            + ", StartIndex = " + startIndex + ", EndIndex = "+ endIndex);
    }
}
