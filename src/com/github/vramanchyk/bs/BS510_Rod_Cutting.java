package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS510_Rod_Cutting {

    private int find(int n, int[] prices, int[] dp) {
        if (n == 0) {
            return prices[0];
        }

        if (dp[n - 1] != -1) {
            return dp[n];
        }

        int max = prices[n];
        for (int cur = 0; cur < n; cur++) {
            max = Math.max(max, prices[cur] + find(n - cur - 1, prices, dp));
        }

        return dp[n] = max;
    }

    public int solve(int[] prices, int n) {
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return find(--n, prices, dp);
    }
}
