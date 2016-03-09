package com.muks.IntrvAlgorithms.StockpriceMaxGain;

/**
 * Created by mukthar.ahmed on 3/9/16.
 */
public class StockMaxGain {
    public static void main(String[] args) {
        int[] stocks = {7, 2, 3, 4, 5, 4, 2, 1};
        findBestPrices(stocks);
    }

    public static void findBestPrices(int[] prices){
        int lowIndex = 0;
        int highIndex = 0;

        if(prices.length == 0 || prices.length == 1){
            //error message
        } else {
            for (int i=1; i < prices.length; i++) {
                if (prices[i] < prices[lowIndex]) {
                    if (i != prices.length-1) { //if last element is lowest, don't change
                        lowIndex = i;
                        highIndex = i;
                    }
                }
                if (prices[i] > prices[highIndex]){
                    highIndex = i;
                }
            }
        }
        System.out.println("Lowest Price " + prices[lowIndex] +
            " Highest Price " + prices[highIndex]);
    }
}
