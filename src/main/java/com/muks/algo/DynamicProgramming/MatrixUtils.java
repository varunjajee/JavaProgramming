package com.muks.algo.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 3/3/16.
 */
public class MatrixUtils {
    public static void printMatrix(int[][] Table) {
        // Printing the matrix
//        System.out.println("\n+ Printing the matrix: \n");
//        for (int w = 0; w <= Table.length; w++) {
//            System.out.format("%4d", w);
//        }
//        System.out.println("\n  --------------------------------");

        for (int[] rows : Table) {
            for (int col : rows) {
                System.out.format("%4d", col);
            }

            System.out.println("");

        }
    }
}
