package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS127_Longest_Increasing_Path {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private boolean fit(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private int solve(int row, int col, int[][] path, int[][] matrix) {
        if (path[row][col] != -1) {
            return path[row][col];
        }

        int ans = 1;
        for (int[] dir : DIR) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (fit(x, y, path.length, path[0].length)) {

                if (matrix[x][y] > matrix[row][col]) {
                    ans = Math.max(ans, solve(x, y, path, matrix) + 1);
                }

            }
        }

        return path[row][col] = ans;
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int[][] path = new int[n][m];
        for (int[] row : path) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (path[row][col] == -1) {
                    solve(row, col, path, matrix);
                }

                ans = Math.max(ans, path[row][col]);
            }
        }

        return ans;
    }
}
