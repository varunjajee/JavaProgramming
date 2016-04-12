package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/11/16.
 *
 * - Catering different set of 2d arrays
 */
public class InputMatrixSets {

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

        PrintingMatrix.printMatrix(matrix);

        return matrix;
    }

}
