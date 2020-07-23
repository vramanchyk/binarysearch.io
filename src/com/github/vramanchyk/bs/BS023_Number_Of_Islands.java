package com.github.vramanchyk.bs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS023_Number_Of_Islands {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private void dfs(int x, int y, int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        matrix[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (fit(xx, yy, matrix.length, matrix[0].length)) {
                    if (matrix[xx][yy] == 1) {
                        matrix[xx][yy] = 0;
                        queue.add(new int[]{xx, yy});
                    }
                }
            }
        }
    }

    public int solve(int[][] matrix) {
        int islands = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    islands++;
                    dfs(row, col, matrix);
                }
            }
        }

        return islands;
    }
}
