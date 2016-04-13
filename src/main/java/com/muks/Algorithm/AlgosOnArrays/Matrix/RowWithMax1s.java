package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/12/16.
 *
 * - Q: In a sorted matrix, find the row having max no. of 1s.
 *
 *  Since each row is sorted, we can use Binary Search to count of 1s in each row. We find the index of first
 *  instance of 1 in each row.
 *
 *  Total 1's = (total number of columns) minus (the index of first 1)
 */
public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] matrx = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        rowWithMax1s(matrx);

    }

    // The main function that returns index of row with maximum number of 1s.
    private static void rowWithMax1s(int[][] mat) {
        int max_row_index = 0, max = -1; // Initialize max values
        int rows = mat.length;
        int cols = mat[0].length;

        // Traverse for each row and count number of 1s by finding the index of first 1
        int i, index;
        for (i = 0; i < rows; i++) {

            index = indexByBinarySearch(mat[i], 0, cols-1);

            if (index != -1 && cols-index > max) {
                max = cols - index;
                max_row_index = i;
            }
        }

        System.out.println("# Row index with max 1s = " + max_row_index + ", Total 1s = " + max);
    }

    /** Find the index of first 1s occurrence */
    private static int indexByBinarySearch(int[] arr, int low, int high) {
        if (high >= low) {

            int mid = low + (high - low)/2;

            // check if the element at middle index is indexByBinarySearch 1
            if ( ( mid == 0 || arr[mid-1] == 0) && arr[mid] == 1) {
                return mid;
            }
            else if (arr[mid] == 0) {   /** if element is 0, recur for right side, since row is sorted */
                return indexByBinarySearch(arr, (mid + 1), high);
            }
            else {
                return indexByBinarySearch(arr, low, (mid - 1));
            }
        }
        return -1;
    }
}
