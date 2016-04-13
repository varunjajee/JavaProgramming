package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Created by mukthar.ahmed on 3/30/16.
 *
 *  Find median from continuous input of integer stream
 *  After reading 1st element of stream - 5 -> median - 5
 *  After reading 2nd element of stream - 5, 15 -> median - 10
 *  After reading 3rd element of stream - 5, 15, 1 -> median - 5
 *  After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 *
 *   Logic:
 *      - If there are odd set of integers, then the middle element is the median
 *      - If even, then (sum of 2 mid elements)/2 is the median
 *
 *   Its best solved using min and max heap
 *      - Similar to balancing BST in Method 2 above, we can use a max heap on left side to represent elements that
 *      are less than effective median, and a min heap on right side to represent elements that are greater than
 *      effective median
 */
public class MedianFromInputStreamUsingHeap {

    static class MedianFinder {
        private PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> rightPQ = new PriorityQueue<>();

        /**
         * Adds a number into the data structure.
         */
        public void addNum(int num) {
            if (leftPQ.isEmpty() || num <= leftPQ.peek()) {
                leftPQ.offer(num);
            } else {
                rightPQ.offer(num);
            }

            System.out.println("# Left-PQ: " + leftPQ.toString() + ", Right-PG: " + rightPQ.toString());

            /** Re balance the pqs */
            if (leftPQ.size() - rightPQ.size() > 1) {
                rightPQ.offer(leftPQ.poll());

            } else if (rightPQ.size() - leftPQ.size() > 1) {
                leftPQ.offer(rightPQ.poll());

            }
        }

        /**
         * Returns the median of current data stream
         */
        public double findMedian() {
            if (leftPQ.isEmpty() && rightPQ.isEmpty()) {    // if the queue is empty
                throw new NoSuchElementException("# Median cannot be found in the empty heap");
            }

            if ( leftPQ.isEmpty() ) {
                return (double) rightPQ.peek();

            } else if ( rightPQ.isEmpty() ) {
                return (double) leftPQ.peek();

            } else if ( leftPQ.size() > rightPQ.size() ) {
                return (double) leftPQ.peek();

            } else if ( rightPQ.size() > leftPQ.size() ) {
                return (double) rightPQ.peek();

            } else {
                return (double) (leftPQ.peek() + rightPQ.peek()) / 2;
            }
        }
    }


    public static void main(String[] args) {
        int[] input1 = {2, 4};

        MedianFinder medianFinder = new MedianFinder();
        for (int i : input1) {
            medianFinder.addNum(i);
        }

        System.out.println("+ Median: " + medianFinder.findMedian());
        medianFinder.addNum(3);

        System.out.println("+ Median: " + medianFinder.findMedian());

    }

}
