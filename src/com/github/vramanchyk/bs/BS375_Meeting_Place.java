package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 8/22/20.
 */
public class BS375_Meeting_Place {

    private final int INF = Integer.MAX_VALUE;

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private int[][] findRoutes(int x, int y, int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;

        final int[][] result = getMatrix(n, m);

        final Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        result[x][y] = 0;

        while (!queue.isEmpty()) {
            final int[] cur = queue.poll();
            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (fit(xx, yy, n, m) && mat[xx][yy] != 1 && result[xx][yy] == INF) {
                    result[xx][yy] = result[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{xx, yy});
                }
            }
        }

        return result;
    }

    private int[][] merge(int n, int m, int[][] src, int[][] dst) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (src[i][j] == INF || dst[i][j] == INF) {
                    dst[i][j] = INF;
                } else {
                    dst[i][j] = dst[i][j] + src[i][j];
                }
            }
        }

        return dst;
    }

    private int getMeetingPlace(int n, int m, int[][] mat) {
        int result = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.min(result, mat[i][j]);
            }
        }

        return result;
    }

    private int[][] getMatrix(int n, int m) {
        int[][] mat = new int[n][m];
        for (int[] row : mat) {
            Arrays.fill(row, INF);
        }
        return mat;
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 2) {
                    int[][] mat = findRoutes(i, j, matrix);
                    result = merge(n, m, mat, result);
                }
            }
        }

        return getMeetingPlace(n, m, result);
    }
}
