package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS125_A_Maniacal_Walk {

    private final int MOD = 1_000_000_007;

    public int solve(int length, int n) {
        final int[][] dp = new int[length][n + 1];

        dp[0][0] = 1;

        for (int step = 1; step <= n; step++) {
            for (int position = 0; position < length; position++) {
                dp[position][step] = dp[position][step - 1];

                if (position - 1 >= 0) {
                    dp[position][step] = (dp[position][step] + dp[position - 1][step - 1]) % MOD;
                }
                if (position + 1 < length) {
                    dp[position][step] = (dp[position][step] + dp[position + 1][step - 1]) % MOD;
                }
            }
        }

        return dp[0][n];
    }
}
