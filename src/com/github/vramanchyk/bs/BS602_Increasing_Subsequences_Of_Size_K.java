package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS602_Increasing_Subsequences_Of_Size_K {

    private final int MOD = 1_000_000_007;

    public int solve(int[] nums, int k) {
        final int n = nums.length;
        int[][] dp = new int[n][k];

        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    for (int t = 0; t < k - 1; t++) {
                        dp[i][t + 1] = (dp[i][t + 1] + dp[j][t]) % MOD;
                    }
                }
            }

            count = (count + dp[i][k - 1]) % MOD;
        }

        return count;
    }
}
