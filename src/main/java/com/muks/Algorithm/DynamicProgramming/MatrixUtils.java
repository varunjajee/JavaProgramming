package com.muks.Algorithm.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 3/3/16.
 */
public class MatrixUtils {
    public static void printMatrix(int[][] Table) {
        for (int[] rows : Table) {
            for (int col : rows) {
                System.out.format("%4d", col);
            }

            System.out.println("");

        }
    }
}
