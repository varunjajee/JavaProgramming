package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/12/16.
 *
 *  - Printing matrix in various forms
 */
public class PrintingMatrix {

    public static void main(String[] args) {

        //printMatrix(InputMatrixSets.getBasicMatrix());
        //printDiagonalByRecursion(InputMatrixSets.getBasicMatrix(), 0, 0);

        printDiagonalRightToBottomLeft(InputMatrixSets.getBasicMatrix());
    }


    /** Print 2d array in matrix form   */
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

    /** Print diagonally, using recursion */
    private  static void printDiagonalByRecursion (int[][] matrix, int i, int j) {
        int n = matrix.length -1;
        if (i > n && j > n) {
            return;
        }

        System.out.println( matrix[i][j] );
        printDiagonalByRecursion(matrix, i+1, j+1);
    }



    /** Printing all diagonal elements...   */
    private static void printDiagonalRightToBottomLeft(int[][] matrix) {
        int rows = matrix.length;

        for (int i = 0, j = 0; i < rows; i++, j++) {
            System.out.println( matrix[i][j] );
        }
    }



    /** print the diagonal elements from left to right bottom   */
    public static void printDiagonalLeft2RightBottom(int[][] matrix) {
        int rows = matrix.length;
        System.out.println("\n+ Printing diagonal elements..");

        for(int i=0, j=0; i < rows; i++, j++) {
            System.out.println(matrix[i][j]);
        }
    }
}
