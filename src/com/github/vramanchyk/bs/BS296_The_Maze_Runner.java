package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS296_The_Maze_Runner {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private int getPath(int[][] mat) {
        if (mat[0][0] == 1) {
            return -1;
        }

        final int n = mat.length;
        final int m = mat[0].length;

        if (n == 1 && m == 1) {
            return 1;
        }

        final Queue<int[]> queue = new LinkedList<>();
        mat[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (fit(xx, yy, n, m) && mat[xx][yy] == 0) {
                    mat[xx][yy] = mat[cur[0]][cur[1]] + 1;
                    if (xx == n - 1 && yy == m - 1) {
                        return mat[xx][yy];
                    }
                    queue.add(new int[]{xx, yy});
                }
            }
        }

        return -1;
    }

    public int solve(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        return getPath(matrix);
    }
}
