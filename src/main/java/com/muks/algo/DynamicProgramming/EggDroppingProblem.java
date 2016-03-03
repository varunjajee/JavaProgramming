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
        int totalEggs = 2;
        int totalFloors = 6;

        //System.out.println("+ Breaks by floor = " + CalculateEggDropFloor(totalEggs, totalFloors));
        EggDroppingDyncProgramming(totalEggs, totalFloors);
    }

    public static int EggDroppingDyncProgramming(int totalEggs, int totalFloors) {
        int[][] Table = new int[totalEggs + 1][totalFloors + 1];
        // This is optional : We need one trial for one floor & 0 trials for 0 floors
        for (int i = 1; i <= totalEggs; i++) {
            Table[i][1] = 1;
            Table[i][0] = 0;
        }


        // We always need j trials for one egg and j floors.
        for (int j = 1; j <= totalFloors; j++)
            Table[1][j] = j;

        MatrixUtils.printMatrix(Table);

        // start iterating from 2 eggs since the row is covered with 1 egg above
        for (int i = 2; i <= totalEggs; i++) {
            for (int j = 1; j <= totalFloors; j++) {

                /** This is important as we want the min of all the values*/
                Table[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k <= j; k++) {
                    int val = 1 + Math.max(Table[i - 1][k - 1], Table[i][j - k]);

                    if (val < Table[i][j]) {
                        Table[i][j] = val;      /** This is setting min of all we got */
                    }
                }
            }
        }

        System.out.println("======");
        MatrixUtils.printMatrix(Table);
        System.out.println("\n" +
            "+ Answer = " + Table[totalEggs][totalFloors] +
            ", Total Eggs = " + totalEggs +
                " with Total Floors = " + totalFloors);

        return Table[totalEggs][totalFloors];
    }
}
