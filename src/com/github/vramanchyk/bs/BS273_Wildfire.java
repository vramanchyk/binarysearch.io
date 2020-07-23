package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 *
 * @see <a href="https://binarysearch.io/problems/Wildfire">https://binarysearch.io/problems/Wildfire</a>
 */
public class BS273_Wildfire {

    private final int[][] DIR = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public int solve(int[][] matrix) {

        if (matrix.length == 0 || matrix[1].length == 0) {
            return 0;
        }

        final int n = matrix.length;
        final int m = matrix[1].length;

        final Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = -1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : DIR) {
                final int xx = cur[0] + dir[0];
                final int yy = cur[1] + dir[1];

                if (fit(xx, yy, n, m)) {
                    if (matrix[xx][yy] == 1) {
                        matrix[xx][yy] = matrix[cur[0]][cur[1]] - 1;
                        queue.add(new int[]{xx, yy});
                    }
                }
            }
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    return -1;
                }

                min = Math.min(min, matrix[i][j]);
            }
        }

        return min < 0 ? -min - 1 : 0;
    }
}
