package com.muks.IntrvAlgorithms.StockpriceMaxGain;

/**
 * - Created by mukthar.ahmed on 3/9/16.
 */
public class StockMaxGain {
    public static void main(String[] args) {
        //int[] stocks = {7, 2, 3, 4, 5, 4, 6, 1};  // case # 1
        //int[] stocks = {7, 2, 3, 2, 5, 1, 0}; // case # 2
        int[] stocks = {7, 2, 3, 2, 5, 1, 1};   // case # 3
        //int[] stocks = {1, 1, 1, 1, 1, 1};   // case # 4

        StockApi(stocks);
    }

    public static void StockApi(int[] prices) {
        int len = prices.length;

        int maxStrike = 0, maxProfit = 0;
        int buy = 0, sell = 0;          /** Buying & selling index */

        for (int i = len - 1; i >= 0; i--) {
            /** Finding max in one pass (Selling price) */
            if (maxStrike < prices[i] & i > 0) {
                maxStrike = prices[i];

                sell = i;
            }

            /** Entry criteria: If price < max & profit is max than what we have seen till now */
            int profit = maxStrike - prices[i];

            if (prices[i] < maxStrike & maxProfit < profit) {
                maxProfit = profit;

                buy = i;
            }
        }

        System.out.println("+ Buy @ " + prices[buy] + " on day = " + buy + " and Sell @ " + maxStrike + " on day = " +
            sell);

    }

}   // end class