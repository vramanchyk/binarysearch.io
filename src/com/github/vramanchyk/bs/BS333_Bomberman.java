package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/3/20.
 */
public class BS333_Bomberman {

    public int solve(int[][] matrix) {
        final int n = matrix.length;

        if (n == 0) {
            return 0;
        }

        final int m = matrix[0].length;

        if (m == 0) {
            return 0;
        }

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] = cols[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!rows[i] && !cols[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
