package com.muks.IntrvAlgorithms.StockpriceMaxGain;

/**
 * Created by mukthar.ahmed on 3/9/16.
 */
public class StockMaxGain {
    public static void main(String[] args) {
        int[] stocks = {7, 2, 3, 4, 5, 4, 0, 1};

        maxGainStocks(stocks, stocks.length);
    }

    public static void maxGainStocks(int[] prices, int n) {
        int max = prices[n-1];
        int profit = 0;
        for (int j = n-1; j > 0; j--) {
            if(prices[j]>max) {
                max = prices[j];
                System.out.println("+ Selling day = " + j);
            }
            profit=profit+max-prices[j];
            System.out.println("+ Buying day = " + j + ", with profit = " + profit);

        }

    }


}
