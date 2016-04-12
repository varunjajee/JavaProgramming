package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/11/16.
 */
public class AMatrixUtils {

    public static int[][] getSortedMatrix() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        return matrix;
    }

    public static int[][] getBasicMatrix() {
        int[][] matrix =  {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };


        printMatrix(matrix);
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("# Matrix:\n------");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
        System.out.println("------\n");
    }
    public static void printMatrix(boolean[][] matrix) {
        System.out.println("# Matrix:\n------");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
        System.out.println("------\n");
    }

}
