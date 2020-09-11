package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/11/20.
 */
public class BS059_CREAM {

    public int solve(int[] prices, int k) {

        if (prices.length == 0 || k == 0) {
            return 0;
        }

        final int n = prices.length;
        final int[][] dp = new int[n + 1][k + 1];

        int maxProfit = 0;

        for (int op = 0; op < k; op++) {
            for (int sell = 1; sell < n; sell++) {
                for (int buy = 0; buy < sell; buy++) {

                    int profit = prices[sell] - prices[buy];
                    if (buy > 0 && op > 0) {
                        profit += dp[buy - 1][op - 1];
                    }

                    dp[sell][op] = Math.max(dp[sell][op], profit);
                }

                dp[sell][op] = Math.max(dp[sell][op], dp[sell - 1][op]);
            }

            maxProfit = Math.max(maxProfit, dp[n - 1][op]);
        }

        return maxProfit;
    }
}
