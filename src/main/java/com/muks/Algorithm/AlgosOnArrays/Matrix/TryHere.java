package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mukthar.ahmed on 4/12/16.
 */
public class TryHere {

    static PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> rightQ = new PriorityQueue<>();


    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 1}
        };

        List<Integer> paths = new ArrayList<>();
        getPaths(matrix, 0, 0, paths);

        System.out.println("# " + paths.toString());
    }

    private static void getPaths(int[][] matrix, int i, int j, List<Integer> path) {
        int rows = matrix.length - 1;

        if (i > rows || j > rows) {
            return;
        }

        else if (matrix[i][j] == 1) {


            if (i == rows || j == rows) {
                path.add(matrix[i][j]);
            }
            else {
                getPaths(matrix, i, j+1, path);
                getPaths(matrix, i+1, j, path);
            }
        }
    }


}
