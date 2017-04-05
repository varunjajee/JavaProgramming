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


    /** Find max sum amongst the matrix rather benchmarking it to 0
     *  This is going to work for only positive integers
     * */


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


    /**
     *
     *  - Scala implementation of matrix having negative integers as well.
     object Solution {

     def main(args: Array[String]) {
     val sc = new java.util.Scanner (System.in);
     var arr = Array.ofDim[Int](6,6);
     for(arr_i <- 0 to 6-1) {
     for(arr_j <- 0 to 6-1){
     arr(arr_i)(arr_j) = sc.nextInt();
     }
     }

     var currentArray = Array.ofDim[Int] (3,3);
     var currentSum = 0
     var maxArray = Array.ofDim[Int] (3,3);
     var maxSum = 0


     var horizontalPositionHolder = 0
     var verticalPositionHolder = 0
     var currentArrayVerticalTemp = 0
     var currentArrayHorizontalTemp = 0

     for(arrVerticalLoop <- 0 to 3){
     for(arrHorizontalLoop <- 0 to 3) {

     verticalPositionHolder = arrVerticalLoop
     horizontalPositionHolder = arrHorizontalLoop

     currentArrayVerticalTemp = 0
     currentArrayHorizontalTemp = 0

     for(arrVertical <- verticalPositionHolder to verticalPositionHolder + 2){
     for(arrHorizontal <- horizontalPositionHolder to horizontalPositionHolder + 2) {
     currentArray(currentArrayVerticalTemp) (currentArrayHorizontalTemp)  = arr(arrVertical) (arrHorizontal)
     currentArrayHorizontalTemp = currentArrayHorizontalTemp + 1
     }
     currentArrayHorizontalTemp = 0
     currentArrayVerticalTemp = currentArrayVerticalTemp + 1
     }

     currentSum = 0

     for(t1 <- 0 to 2){
     for(t2 <- 0 to 2) {
     currentSum = currentSum + currentArray(t1)(t2)
     }
     }
     currentSum = currentSum - currentArray(1)(0) - currentArray(1)(2)

     if(arrVerticalLoop == 0 && arrHorizontalLoop == 0){
     maxSum =  currentSum
     maxArray = currentArray
     }

     if(currentSum > maxSum) {
     maxSum = currentSum
     maxArray = currentArray
     }

     }
     }

     println(maxSum)
     }
     }
     */

}
