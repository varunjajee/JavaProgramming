package com.muks.algo.additionalalgos;

/*
    Created by mukthar.ahmed on 2/3/16.

    Link: http://romanenco.com/coin-change-problem/

    Q: Find minimum number of coins to form a sub/total of a number
        - Solved by dynamic programming and memoization
 */


import java.util.ArrayList;
import java.util.List;

public class CoinsMinNum {
    /*
        Algorithm:
        For all j from 0....j coins, find T[i] = min( T[i], 1 + T[i - coins[j] ] ) where i =
        total number
     */


    public static void minCoinsBottomUp(int total, int[] coins) {
        int[] T = new int[total+1];
        int[] R = new int[total+1];

        // initialize both the arrays
        T[0] = 0;
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }


        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {

                if (i >= coins[j]) {    // entry criteria
                    if ( T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }

        }

        // Print combination
        printCoinCombination(R, coins);
    }

    private static void printCoinCombination(int[] R, int[] coins) {
        List<Integer> minCoins = new ArrayList<>();

        if (R[R.length - 1] == -1) {
            System.out.println("+ Warning: There's no possible solution.");
            return;
        }

        int start = R.length - 1;
        System.out.println("+ Coins used to form the total = ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.println(coins[j] + " ");
            minCoins.add(coins[j]);

            start = start - coins[j];
        }

        System.out.println("\n");
        System.out.println("+ Coins are:" );
        for (int i = 0; i < minCoins.size(); i++) {
            System.out.print(" " + minCoins.get(i));
        }
    }


    public static void main(String[] args) {
        int total = 6;
        int[] coins = {3, 2, 4};

        minCoinsBottomUp(total, coins);     // get answer
    }


    // class showing the usage of memoization for obtaining min no. of coins for a total
    public class CoinChangeTD {
        private final int[] coins;
        private final int sum;
        private final int[] memo;

        public CoinChangeTD(int[] coins, int sum) {
            this.coins = coins;
            this.sum = sum;
            memo = new int[sum + 1];
            for (int i = 0; i < sum + 1; i++) {
                memo[i] = -1;
            }
            memo[0] = 0;
        }

        public int getMinNumberOfCoins() {
            return getMinNumberOfCoins(sum);
        }

        private int getMinNumberOfCoins(int sum) {
            if (memo[sum] != -1) {  // eliminate duplicated calculations
                return memo[sum];
            }
            if (sum == 0) {
                return 0;  // base case
            }
            int result = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (coin <= sum) {
                    result = Math.min(
                            result,
                            getMinNumberOfCoins(sum - coin) + 1
                    );
                }
            }
            memo[sum] = result;  // save for reuse
            return result;
        }

    }
}
