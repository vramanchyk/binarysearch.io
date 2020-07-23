package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS080_Zero_Matrix {

    public int[][] solve(int[][] matrix) {

        final int n = matrix.length;
        final int m = matrix[0].length;

        boolean hasInFirstRow = false;
        boolean hasInFirstCol = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    hasInFirstRow |= i == 0;
                    hasInFirstCol |= j == 0;
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (hasInFirstCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (hasInFirstRow) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        return matrix;
    }
}
