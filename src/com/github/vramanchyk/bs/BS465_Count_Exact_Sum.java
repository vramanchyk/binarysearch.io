package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS465_Count_Exact_Sum {

    private final int MOD = 1_000_000_007;

    private int count(int n, int[] nums, int[][] dp, int s) {
        if (s == 0) {
            return 1;
        }

        if (s < 0 || n < 0) {
            return 0;
        }


        if (dp[n][s] != -1) {
            return dp[n][s];
        }

        int res = 0;
        res = (res + count(n - 1, nums, dp, s)) % MOD;
        res = (res + count(n - 1, nums, dp, s - nums[n])) % MOD;

        return dp[n][s] = res;
    }

    public int solve(int[] nums, int k) {
        final int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return count(n - 1, nums, dp, k);
    }
}
