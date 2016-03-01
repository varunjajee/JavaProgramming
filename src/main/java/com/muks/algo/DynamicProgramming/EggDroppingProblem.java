package com.muks.algo.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 2/23/16.
 * <p>
 * Egg - e/i
 * Floors - f/j
 * <p>
 * if (i > j)
 * T[i][j] = T[i-1][j]   -> just get the value from the top
 * else
 * T[i][j] = 1 + min( max(T[i-1][j-1]) )
 */
public class EggDroppingProblem {
    public static void main(String[] args) {
        int totalEggs = 5;
        int totalFloors = 10;

        System.out.println("+ Breaks by floor = " + CalculateEggDropFloor(totalEggs, totalFloors));
    }

    public static int CalculateEggDropFloor(int totalEggs, int totalFloors) {
        int[][] Table = new int[totalEggs + 1][totalFloors + 1];

        for (int i = 0; i <= totalEggs; i++) {  // initialize the first row with min/worst case attempts
            Table[1][i] = i;
        }


        // start iterating from 2 eggs since the row is covered with 1 egg above
        for (int e = 2; e <= totalEggs; e++) {
            for (int f = 1; f <= totalFloors; f++) {
                Table[e][f] = Integer.MAX_VALUE;

                for (int k = 1; k <= f; k++) {
                    int val = 1 + Math.max(Table[e - 1][k - 1], Table[e][f - k]);

                    if (val < Table[e][f]) {
                        Table[e][f] = val;
                    }
                }
            }
        }

        return Table[totalEggs][totalEggs];

    }

}
