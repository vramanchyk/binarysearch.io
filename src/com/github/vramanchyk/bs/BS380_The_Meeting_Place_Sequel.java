package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS380_The_Meeting_Place_Sequel {

    private final int INF = Integer.MAX_VALUE;

    private final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private int[][] findTime(int x, int y, int n, int m, int[][] matrix) {
        final Queue<int[]> queue = new LinkedList<>();

        final int[][] result = new int[n][m];

        for (int row = 0; row < n; row++) {
            Arrays.fill(result[row], INF);
        }

        final boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        result[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : DIR) {
                x = current[0] + dir[0];
                y = current[1] + dir[1];
                if (fit(x, y, n, m) && !visited[x][y] && matrix[x][y] != 1) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                    result[x][y] = result[current[0]][current[1]] + 1;
                }
            }
        }

        return result;
    }

    private void merge(int n, int m, int[][] a, int[][] b) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                a[row][col] = Math.max(a[row][col], b[row][col]);
            }
        }
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        int[][] times = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 2) {
                    int[][] time = findTime(row, col, n, m, matrix);
                    merge(n, m, times, time);
                }
            }
        }

        int result = n * m;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] != 1 && times[row][col] != INF) {
                    result = Math.min(result, times[row][col]);
                }
            }
        }

        return result;
    }
}
