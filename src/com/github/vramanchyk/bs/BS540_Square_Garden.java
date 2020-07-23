package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS540_Square_Garden {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(
                            matrix[i - 1][j - 1],
                            Math.min(matrix[i - 1][j], matrix[i][j - 1])
                    ) + 1;
                }

                ans += matrix[i][j];
            }
        }

        return ans;
    }
}
