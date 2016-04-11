package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/10/16.
 * <p>
 * - Search an element in a matrix of sorted integers.
 */

public class SearchFromSorted {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        System.out.println("# Found = " + searchMatrix(matrix, 34));
    }


    private static boolean searchMatrix(int[][] matrix, int target) {
        /** base case */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;      /** rows */
        int cols = matrix[0].length;   /** columns */

        int start = 0;
        int end = (rows * cols) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midX = mid / cols;
            int midY = mid % cols;

            System.out.println("# Mid=" + mid + ", N=" + cols + ", midX=" + midX + ", midY=" + midY);

            if (matrix[midX][midY] == target) {
                System.out.println("# Found @ (X = " + midX + ", Y = " + midY + ")");
                return true;
            }

            if (target < matrix[midX][midY]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
