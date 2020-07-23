package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS013_Collecting_Coins {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i > 0 ? ans[i - 1][j] : 0;
                int left = j > 0 ? ans[i][j - 1] : 0;
                ans[i][j] = Math.max(top, left) + matrix[i][j];
            }
        }

        return ans[n - 1][m - 1];
    }
}
