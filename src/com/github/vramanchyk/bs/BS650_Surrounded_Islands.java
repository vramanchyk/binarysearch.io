package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 8/3/20.
 */
public class BS650_Surrounded_Islands {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private void fill(int x, int y, int n, int m, int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        mat[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (fit(xx, yy, n, m) && mat[xx][yy] == 1) {
                    mat[xx][yy] = 0;
                    queue.add(new int[]{xx, yy});
                }
            }
        }
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 1) {
                fill(i, 0, n, m, matrix);
            }
            if (matrix[i][m - 1] == 1) {
                fill(i, m - 1, n, m, matrix);
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 1) {
                fill(0, j, n, m, matrix);
            }
            if (matrix[n - 1][j] == 1) {
                fill(n - 1, j, n, m, matrix);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    fill(i, j, n, m, matrix);
                }
            }
        }

        return count;
    }
}
