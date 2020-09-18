package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/18/20.
 */
public class BS725_Rectangle_Garden {

    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int n = matrix.length;
        final int m = matrix[0].length;

        final int[][] dp = new int[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + (i > 0 ? dp[i - 1][j] : 0);

                    int minH = dp[i][j];

                    for (int k = j; k >= 0; k--) {
                        minH = Math.min(minH, dp[i][k]);

                        if (minH == 0) {
                            break;
                        }

                        count += minH;
                    }
                }
            }
        }

        return count;
    }
}
