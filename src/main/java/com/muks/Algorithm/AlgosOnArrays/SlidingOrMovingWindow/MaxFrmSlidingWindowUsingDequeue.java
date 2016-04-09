package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

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

        //naiveMaxSolution(arr, k);

        maxSlidingWindow(arr, k);
    }




    static void maxSlidingWindow(int[] arr, int w) {
        Deque<Integer> Q = new ArrayDeque<>();

        //Initilize deque Q for first window
        for (int i = 0; i < w; i++) {
            while ( !Q.isEmpty() && arr[i] >= arr[Q.getLast()]) {
                Q.removeLast();
            }

            Q.addLast(i);
        }

        for (int i = w; i < arr.length; i++) {
            System.out.println( arr[Q.getFirst()]);

            //update Q for new window
            while (!Q.isEmpty() && arr[i] >= arr[Q.getLast()]) {
                Q.removeLast();
            }

            //Pop older element outside window from Q
            while (!Q.isEmpty() && Q.getFirst() <= i-w) {
                Q.removeLast();
            }

            Q.addLast(i);   //Insert current element in Q
        }

        //B[n-w] = arr[Q.getFirst()];
        System.out.print(" " + arr[Q.getFirst()]);
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
