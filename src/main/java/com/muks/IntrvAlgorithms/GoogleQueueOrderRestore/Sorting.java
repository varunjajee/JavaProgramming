package com.muks.IntrvAlgorithms.GoogleQueueOrderRestore;

/*
 * Created by mukthar.ahmed on 2/15/16.
 */


public class Sorting {
    public static void main(String[] args) {

        int[][] queue = {{5, 0}, {3, 1}, {6, 1} , {4, 1}, {2, 0}, {1, 4}};
        reverseSort(queue);

        for (int[] i : queue) {
            System.out.print(" (" + i[0] + ", " + i[1] + ")");
        }
    }

    public static int[][] reverseSort(int[][] mainArray) {
        if (mainArray.length <= 1) {
            return mainArray;
        }

        // Split the array in half
        int mid = mainArray.length/2;
        int[][] first = new int[mid][2];
        int[][] second = new int[mainArray.length - mid][2];

        int i;
        for (i = 0 ; i < mid; i++) {
            first[i] = mainArray[i];
        }

        for (int j = mid; j < mainArray.length; j++) {
            second[j - mid] = mainArray[j];
        }

        // Sort each half
        reverseSort(first);
        reverseSort(second);

        // Merge the halves together, overwriting the original array
        reverseMerge(first, second, mainArray);
        return mainArray;
    }

    private static void reverseMerge(int[][] first, int[][] second, int[][] actualArray) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;



        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst][0] > second[iSecond][0]) {
                actualArray[j] = first[iFirst];
                iFirst++;
            } else {
                actualArray[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // copy what's left
        System.arraycopy(first, iFirst, actualArray, j, first.length - iFirst);
        System.arraycopy(second, iSecond, actualArray, j, second.length - iSecond);
    }
}
