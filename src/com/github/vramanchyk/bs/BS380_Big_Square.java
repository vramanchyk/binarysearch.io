package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS380_Big_Square {

    public int solve(int[][] matrix) {
        final int n = matrix.length;

        if (n == 0) {
            return 0;
        }

        final int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                    }
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }
}
