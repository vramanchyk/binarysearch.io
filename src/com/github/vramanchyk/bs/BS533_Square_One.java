package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS533_Square_One {

    public int solve(int[][] matrix) {

        final int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        final int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int ans = 1;
        final int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    final int v = matrix[i][j];
                    if (v == matrix[i - 1][j] && v == matrix[i][j - 1] && v == matrix[i - 1][j - 1]) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }

                    dp[i][j]++;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }
}
