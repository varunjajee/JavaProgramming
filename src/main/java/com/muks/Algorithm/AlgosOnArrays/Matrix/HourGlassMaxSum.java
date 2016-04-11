package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.Scanner;

/**
 * Created by mukthar.ahmed on 3/26/16.
 *
 * - HourGlass, shape matrix.
 *      - Find an hour glass with max sum
 */
public class HourGlassMaxSum {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        int[][] matrix2 = {
            {1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 2, 4, 4},
            {0, 0, 0, 2, 0},
            {0, 0, 1, 2, 4}
        };

        maxSumHourglass(matrix1);
    }

    private static void maxSumHourglass(int[][] arr) {

        int maxSum = 0;
        int sum = 0;

        int rows = arr.length;
        int cols = arr[0].length;

        System.out.println("# Row = " + rows + ", Cols = " + cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if ( (i+2 < rows) && (j+2 < cols) ) {
                    sum = (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);

                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);

    }


}
