package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/6/20.
 */
public class BS319_Latin_Square {

    private int count(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public boolean solve(String[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        final int[] rows = new int[n];
        final int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int bit = 1 << (matrix[i][j].charAt(0) - 'a');
                rows[i] |= bit;
                cols[j] |= bit;
            }
        }

        for (int i = 1; i < n; i++) {
            if (rows[i] != rows[i - 1]) {
                return false;
            }
        }

        for (int j = 1; j < m; j++) {
            if (cols[j] != cols[j - 1]) {
                return false;
            }
        }

        return count(rows[0]) == n;
    }
}
