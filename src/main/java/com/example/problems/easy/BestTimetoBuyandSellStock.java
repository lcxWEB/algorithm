package com.example.problems.easy;

/**
 * Created by lichunxia on 2019-08-28 12:45
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        // int[] arr = {7,6,4,3,1};
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        int maxProfit = bestTimetoBuyandSellStock.maxProfit(arr);
        System.out.println(maxProfit);
    }

    /**
     * 不是自己想的
     * Runtime: 1 ms, faster than 88.81% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int maxProfit = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }
            int currDiff = prices[i] - min;
            if (currDiff > maxProfit) {
                maxProfit = currDiff;
            }
        }
        return maxProfit;
    }

}
