package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS450_Shape_Perimeter {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int perimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    for (int[] dir : DIR) {
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if (!fit(ii, jj, n, m) || matrix[ii][jj] != 1) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}
