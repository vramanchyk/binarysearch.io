package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/26/20.
 */
public class BS017_Labyrinthian_Possibilities {

    private final int MOD = 1_000_000_007;

    public int solve(int[][] matrix) {
        final int n = matrix.length;

        if (n == 0) {
            return 0;
        }

        final int m = matrix[0].length;

        if (m == 0 || matrix[0][0] == 1 || matrix[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    if (i > 0 && matrix[i - 1][j] == 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 0 && matrix[i][j - 1] == 0) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
