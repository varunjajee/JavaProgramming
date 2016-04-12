package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/12/16.
 *  - Traverse spiral for a given matrix
 */
public class SpiralTraversal {

    public static void main(String[] args) {
        int[][] matrix = InputMatrixSets.getBasicMatrix();
        spiralOrderPrinting(matrix);
    }

    static void spiralOrderPrinting(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }

        /** Initialize our four indexes */
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true) {
            /** Print top row   */
            for(int i = left; i <= right; ++i) {
                System.out.print( matrix[top][i] + " ");
            }

            top++;
            if (top > down || left > right) break;

            /** Print the rightmost column */
            for (int j = top; j <= down; ++j) {
                System.out.print( matrix[j][right] + " ");
            }

            right--;
            if (top > down || left > right) break;

            /** Print the bottom row */
            for (int i = right; i >= left; --i) {
                System.out.print(matrix[down][i] + " ");
            }

            down--;
            if (top > down || left > right)  break;

            /** Print the leftmost column */
            for (int i = down; i >= top; --i) {
                System.out.print( matrix[i][left] + " ");
            }

            left++;
            if (top > down || left > right) break;
        }
    }
}
