package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Vitali Ramanchyk on 8/2/20.
 */
public class BS527_Communication_Towers {

    private void fill(int x, int y, List<List<int[]>> rows, List<List<int[]>> cols, int[][] m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        m[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] vals : rows.get(current[0])) {
                if (m[vals[0]][vals[1]] == 1) {
                    m[vals[0]][vals[1]] = 0;
                    queue.add(vals);
                }
            }

            for (int[] vals : cols.get(current[1])) {
                if (m[vals[0]][vals[1]] == 1) {
                    m[vals[0]][vals[1]] = 0;
                    queue.add(vals);
                }
            }
        }
    }


    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        List<List<int[]>> rows = new ArrayList<>(n);
        List<List<int[]>> cols = new ArrayList<>(m);

        for (int row = 0; row < n; row++) {
            rows.add(new LinkedList<>());
        }

        for (int col = 0; col < m; col++) {
            cols.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    rows.get(i).add(new int[]{i, j});
                    cols.get(j).add(new int[]{i, j});
                }
            }
        }

        int groups = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    groups++;
                    fill(i, j, rows, cols, matrix);
                }
            }
        }

        return groups;
    }
}
