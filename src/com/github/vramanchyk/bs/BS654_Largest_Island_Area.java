package com.github.vramanchyk.bs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS654_Largest_Island_Area {

    private final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean fit(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private int getArea(int x, int y, int[][] mat) {

        final int n = mat.length;
        final int m = mat[0].length;

        final Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        mat[x][y] = 0;
        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIR) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];

                if (fit(xx, yy, n, m) && mat[xx][yy] == 1) {
                    area++;
                    mat[xx][yy] = 0;
                    queue.add(new int[]{xx, yy});
                }
            }
        }

        return area;
    }

    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    answer = Math.max(answer, getArea(i, j, matrix));
                }
            }
        }

        return answer;
    }
}
