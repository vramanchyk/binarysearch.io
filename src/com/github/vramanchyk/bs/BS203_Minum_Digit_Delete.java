package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS203_Minum_Digit_Delete {

    public int solve(String a, String b) {
        final int n = a.length();
        final int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + a.charAt(i - 1) - '0';
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + b.charAt(j - 1) - '0';
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j] + a.charAt(i - 1) - '0',
                        dp[i][j - 1] + b.charAt(j - 1) - '0'
                );

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
