package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS447_Maze_Search {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public boolean solve(int[][] matrix) {

        final int n = matrix.length;
        final int m = matrix[0].length;

        if (n == 1 && m == 1) {
            return true;
        }

        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (fit(xx, yy, n, m) && matrix[xx][yy] == 0) {
                    if (xx == n - 1 && yy == m - 1) {
                        return true;
                    }

                    matrix[xx][yy] = 1;
                    queue.add(new int[]{xx, yy});
                }
            }
        }

        return false;
    }
}
