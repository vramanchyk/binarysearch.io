package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/27/20.
 */
public class BS502_Broker_Of_Wall_Street {

    public int solve(int[] prices, int fee) {

        if (prices.length == 0) {
            return 0;
        }

        int maxSell = -prices[0];
        int maxProfit = 0;

        for (int index = 1; index < prices.length; index++) {
            int profit = maxSell + prices[index] - fee;

            maxSell = Math.max(maxSell, maxProfit - prices[index]);

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
