package com.muks.IntrvAlgorithms.SlidingWindowMax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * - Created by mukthar.ahmed on 3/7/16.
 */
public class SlidingWindowProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int sliderSize = 3;

        printKMax(arr, arr.length, sliderSize);

        maxWindowCode(arr, 3);  // get max using Deque

    }

    public static void maxWindowCode(int[] inBuffer, int window) {
        int w = (inBuffer.length < window) ? inBuffer.length : window;

        Deque<Integer> que = new ArrayDeque<>();
        List<Integer> maxList = new ArrayList<>();

        // initialize window
        int i = 0;
        while (i < w) {
            while (!que.isEmpty() && inBuffer[i] >= inBuffer[que.getLast()]) {
                que.removeLast();
            }
            que.addLast(i++);   /** just store the index of maximal element in the window */
        }


        // sliding window
        maxList.add(inBuffer[que.getFirst()]);


        while (i < inBuffer.length) {
            // add new element
            while (!que.isEmpty() && inBuffer[i] >= inBuffer[que.getLast()]) {
                que.removeLast();
            }
            que.addLast(i);

            // remove old element if still in que
            if (!que.isEmpty() && i - w >= que.getFirst()) {
                que.removeFirst();
            }

            // get maximal
            ++i;
            maxList.add(inBuffer[que.getFirst()]);
        }

        System.out.println("\n+ Max Window List = " + maxList.toString());
    }

    /** Using a double ended Queue A.k.a - Deque in java
     * A deque allows insertion/deletion on both ends. Maintain the first as the index of
     * maximal of the window and elements after it are all smaller and came later than the first.
     */
    public static void windowMax(int[] inBuffer, int window) {
        int w = (inBuffer.length < window) ? inBuffer.length : window;
        System.out.println("\n\n+ Window Size = " + w);

        Deque<Integer> que = new ArrayDeque<>();
        List<Integer> maxList = new ArrayList<>();

        // initialize window
        int i=0;
        while (i < w) {
            while (!que.isEmpty() && inBuffer[i] >= inBuffer[que.getLast()] ) {
                que.removeLast();
            }
            que.addLast(i++);   /** just store the index of maximal element in the window */
        }

        System.out.println("+ After init = " + que.toString() );

        // sliding window
        int[] max = new int[inBuffer.length - w + 1];
        System.out.println("+ i=" + i + ", w=" + w);
        max[i - w] = inBuffer[que.getFirst()];
        maxList.add(que.getFirst());

        // {1, 2, 3, 1, 4, 5, 2, 3, 6}

        while (i < inBuffer.length) {
            // add new element
            while (!que.isEmpty() && inBuffer[i] >= inBuffer[que.getLast()] ) {
                System.out.println("inBuffer[" + i + "]=" + inBuffer[i] + " >= " +
                    "inBuffer[LastElem]=" + inBuffer[que.getLast()]);
                que.removeLast();
            }
            que.addLast(i);

            System.out.println("+ i=" + i + ", w=" + w +", First=" + que.getFirst());
//            // remove old element if still in que
//            if (!que.isEmpty() && i - w >= que.getFirst()) {
//                que.removeFirst();
//            }

            // get maximal
            ++i;
            System.out.println("+ i=" + i + ", w=" + w +", First=" + que.getFirst() + "\n");
            max[i - w] = inBuffer[que.getFirst()];
            maxList.add(inBuffer[que.getFirst()]);
        }

        //return max;
        System.out.println("\n+ Max from sliding window: ");
        for (int j : max) {
            System.out.print(" " + j);
        }

        System.out.println("+ List = " + maxList.toString());
    }


    private static void printKMax(int arr[], int n, int k) {
        int j, max;

        for (int i = 0; i <= n - k; i++) {
            max = arr[i];

            for (j = 1; j < k; j++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            System.out.print(" " + max);
        }
    }

}
