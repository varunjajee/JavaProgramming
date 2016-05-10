package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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

        int[] intArr = {-1, 3, -5, 4, 6, -1, 4, -7, 13, -3};
        //naiveMaxSolution(arr, k);

        maxSlidingWindow(intArr, k);
    }




    static void maxSlidingWindow(int[] arr, int w) {
        Deque<Integer> que = new ArrayDeque<>();

        //Initilize deque que for first window
        for (int i = 0; i < w; i++) {
            while ( !que.isEmpty() && arr[i] >= arr[que.getLast()]) {
                que.removeLast();
            }

            que.addLast(i);
        }

        for (int i = w; i < arr.length; i++) {
            System.out.println("\n " + arr[que.getFirst()] + ", # size = " + que.size());

            /** update que for new window */
            while (!que.isEmpty() && arr[i] >= arr[que.getLast()]) {
                que.removeLast();
            }

            /** Pop older element outside window from que */
            System.out.println("# Old: " + que.peek() + " <= " + (i-w));
            while (!que.isEmpty() && que.getFirst() <= i-w) {
                System.out.println("# Old---");
                que.removeLast();
            }

            que.addLast(i);   //Insert current element in que
        }

        //B[n-w] = arr[que.getFirst()];
        System.out.print(" " + arr[que.getFirst()]);
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

    private static String printQ(Deque<Integer> queue, int[] arr) {
        StringBuilder sb = new StringBuilder();

        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(" " + sb.append(arr[itr.next()]) );
        }

        return sb.toString();
    }
}
