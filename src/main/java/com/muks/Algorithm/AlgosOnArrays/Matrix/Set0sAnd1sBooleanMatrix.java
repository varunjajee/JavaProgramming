package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/11/16.
 */
public class Set0sAnd1sBooleanMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        Set0sAnd1sBooleanMatrix.setZerosAndOnes(matrix);

    }

    private static void setZerosAndOnes(int[][] matrix) {
        boolean firstRowOne = false;
        boolean firstColumnOne = false;

        //set indexByBinarySearch row and column zero or not
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                firstColumnOne = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                firstRowOne = true;
                break;
            }
        }

        // First row & column - mark Ones
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][0] = 1;
                    matrix[0][j] = 1;
                }
            }
        }

        //use mark to set elements
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 1 || matrix[0][j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }

        //setting back indexByBinarySearch column and row to 1
        if (firstColumnOne) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 1;
            }
        }

        if (firstRowOne) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 1;
            }
        }

        AMatrixUtils.printMatrix(matrix);

    }
}
