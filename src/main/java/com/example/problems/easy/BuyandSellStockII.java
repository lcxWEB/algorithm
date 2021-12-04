package com.example.problems.easy;

/**
 * Created by lichunxia on 2019-09-15 18:35
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuyandSellStockII {

    public static void main(String[] args) {
        BuyandSellStockII buyandSellStockII = new BuyandSellStockII();
        int[] prices = {1,2,3,4,5};
        int maxProfit = buyandSellStockII.maxProfit(prices);
        System.out.println(maxProfit);
    }


    /**
     * Runtime: 1 ms, faster than 94.57% of Java online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - prices[i -1];
            if (p > 0) {
                profit = profit + p;
            }
        }
        return profit;
    }
}
