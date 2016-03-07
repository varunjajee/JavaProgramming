package com.muks.algo.additionalalgos;

import java.util.ArrayDeque;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class SlidingWindowProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int sliderSize = 3;

        printKMax(arr, arr.length, sliderSize);
    }


    private static void printKMax(int arr[], int n, int k) {
        int j, max;

        for (int i = 0; i <= n-k; i++) {
            max = arr[i];

            for (j = 1; j < k; j++) {
                if (arr[i+j] > max)
                    max = arr[i+j];
            }
            System.out.println(" " + max);
        }
    }


//    void maxSlidingWindow(int A[], int n, int w, int B[]) {
//        ArrayDeque<Integer> Q = new ArrayDeque<>();
//        for (int i = 0; i < w; i++) {
//
//            while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
//                Q.pop_back();
//            Q.push_back(i);
//        }
//        for (int i = w; i < n; i++) {
//            B[i-w] = A[Q.front()];
//            while (!Q.empty() && A[i] >= A[Q.back()])
//                Q.pop_back();
//            while (!Q.empty() && Q.front() <= i-w)
//                Q.pop_front();
//            Q.push_back(i);
//        }
//        B[n-w] = A[Q.front()];
//    }
}
