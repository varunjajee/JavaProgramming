package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 4/13/16.
 *
 *  - Given a matrix of M xMethod N, print all the paths from top-left to bottom-right
 */

public class PrintAllPossiblePaths {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 1}
        };

        List<String> paths = getMatrixPaths(matrix);
        System.out.println("Total = " + paths.size());
    }
    /**
     *
     */
    public static List<String> getMatrixPaths(int[][] matrix){
        System.out.println("\n+ All possible paths in the matrix: ");
        List<String> pathList = new ArrayList<String>();

        if (matrix != null && matrix.length > 0){
            System.out.println("enter");
            getPaths(matrix, 0, 0, "", pathList);
        }
        return pathList;
    }

    private static void getPaths(int[][] matrix, int i, int j, String path, List<String> pathList){

        int rows = matrix.length - 1;
        //int cols = matrix[0].length;

        if(i > rows || j > rows) {
            return;
        }

        else if ( matrix[i][j] == 1 ) {//only 1 is valid
            path += String.format(" (%d,%d)", i , j);

            if( i == rows && j == rows) { // reach (rows,rows) point
                pathList.add(path);

            } else {
                getPaths(matrix, i+1, j , path, pathList);  /** move down */
                getPaths(matrix, i , j+1, path, pathList);  /** move right */
                //getPaths(matrix, i + 1 , j+1, path, pathList);    /** move diagonally */
            }
        }
    }

}
