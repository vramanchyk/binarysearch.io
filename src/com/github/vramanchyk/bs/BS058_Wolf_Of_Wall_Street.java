package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS058_Wolf_Of_Wall_Street {

    public int solve(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];

        for (int index = 1; index < prices.length; index++) {
            int curProfit = prices[index] - min;

            if (curProfit > profit) {
                profit = curProfit;
            }

            if (prices[index] < min) {
                min = prices[index];
            }
        }

        return profit;
    }
}
