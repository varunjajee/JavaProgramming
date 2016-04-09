package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

/**
 * Created by mukthar.ahmed on 4/9/16.
    Q: given a int array, and a sliding window size, find the max within the window

     Input :
     arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6} & window_size = 3
     Output :
     3 3 4 5 5 5 6

     1, 2, 3 = 3
     2, 3, 1 = 3
     3, 1, 3 = 4 and so on.
 */

public class MaxFrmSlidingWindowUsingDequeue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        naiveMaxSolution(arr, k);
    }

    private static void naiveMaxSolution(int[] arr, int k) {


        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];

            for (int j = i; j <= k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            System.out.print(" " +  max);
        }
    }
}
