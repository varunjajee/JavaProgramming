package com.muks.algo.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 2/23/16.
 * <p>
 * 0/1 Knapsack problem:
 * Problem definition: Given a set of values, weights, and a max weight. Collect the values in
 * such a way that the value is max and the weight is >= max-weight
 * <p>
 * Greedy Algorithm doesn't work in this case
 * <p>
 * Dyn programming - Since we have sub-optimal solutions and sub-problems
 * <p>
 * <p>
 * Forumula:
 * i = row, (holding values with their weights 2d array (val, wgt)
 * j = columns (weights spaning from 0 - max-weight)
 * <p>
 * if (j  < wt[i] ) {
 * T[i][j] = T[i-1][j] => what ever best we can do without 'i' is T[i-1][j]
 * }
 * else {
 * T[i][j] = Math.max( T[i-1][j - wt[i]) + val[i] ,  T[i-1][j] )
 * }
 */

public class Knapsack01Problem {

    public static int knapsackDP(int[] val, int[] wt, int maxWeight) {
        int[][] Table = new int[val.length + 1][maxWeight + 1];

        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {

                if (i == 0 || j == 0) {   // init table with 0s in the 1st row
                    Table[i][j] = 0;
                    continue;
                }

                if (j < wt[i - 1]) {
                    Table[i][j] = Table[i - 1][j];

                } else {
                    Table[i][j] = Math.max(Table[i - 1][j - wt[i - 1]] + val[i - 1], Table[i - 1][j]);

                }
            }
        }


        /** Printing the matrix / knapsack - table */
        printMatrix(Table, maxWeight);



        /**
         * Make list of what all items to finally select
         * Logic:
         *       Current Cell value - Cell value of (col - wt) == Cell val of above cell
         * */
        int i = val.length;
        int j = maxWeight;

        System.out.print("\nItems picked where [");
        while (i > 0 && j > 0) {
            if (Table[i][j] - Table[i - 1][j - wt[i - 1]] == val[i - 1]) {
                i--;
                System.out.print(" " + val[i]);

                j -= wt[i];
            } else {
                i--;
            }
        }

        System.out.print(" ]\n");


        return Table[val.length][maxWeight];

    }

    public static void main(String[] args) {
        int[] val = {1, 4, 5, 6};
        int[] wt = {1, 3, 4, 5};
        int maxWeight = 7;

        System.out.println("+ The max value picked = " + knapsackDP(val, wt, maxWeight));
    }


    private static void printMatrix(int[][] Table, int maxWeight) {
        // Printing the matrix
        System.out.println("\n+ Printing the matrix: \n");
        for (int w = 0; w <= maxWeight; w++) {
            System.out.format("%4d", w);
        }
        System.out.println("\n  --------------------------------");

        for (int[] rows : Table) {
            for (int col : rows) {
                System.out.format("%4d", col);
            }

            System.out.println("");

        }
    }
}
