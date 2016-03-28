package com.muks.Algorithm.Matrix;

import java.util.Scanner;

/**
 * Created by mukthar.ahmed on 3/27/16.
 *
 * In a given 2D array/matrix, find an max sum of sub-matrix which is of hour-glass shape
 */

public class HourglassMaxSum {

    public static void main(String[] args) {
        int[][] in = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        printHourglasses(in);
        maxSumHourglass(in);

    }

    private static void maxSumHourglass(int[][] in) {

        int maxSum = 0;
        for( int i = 0 ; i < 4 ; i ++) {
            for( int j = 0 ; j < 4 ; j ++) {
                int t;
                t = in[i][j] + in[i][j+1] + in[i][j+2] + in[i+1][j+1] + in[i+2][j] + in[i+2][j+1] + in[i+2][j+2];
                if ( t > maxSum ) {
                    maxSum = t ;
                }
            }
        }

        System.out.println("+ MaxSum="+ maxSum);
    }

    private static void printHourglasses(int[][] in) {
        for( int i = 0 ; i < 4 ; i ++) {
            for( int j = 0 ; j < 4 ; j ++) {

                System.out.println(
                    in[i][j] + ", " + in[i][j+1] +  ", " + in[i][j+2] + "\n" +
                        + in[i+1][j+1] + "\n"
                        + in[i+2][j] +  ", " + in[i+2][j+1] +  ", " + in[i+2][j+2] + "\n");
            }
        }
    }
}