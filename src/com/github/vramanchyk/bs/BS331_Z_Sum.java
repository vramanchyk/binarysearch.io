package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/6/20.
 */
public class BS331_Z_Sum {

    public int solve(int[][] matrix) {
        final int n = matrix.length;

        if (n == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[0][i] + matrix[n - 1][i] + matrix[i][n - i - 1];
        }

        return sum - matrix[0][n - 1] - matrix[n - 1][0];
    }
}
