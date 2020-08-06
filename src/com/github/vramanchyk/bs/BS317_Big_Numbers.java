package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/6/20.
 */
public class BS317_Big_Numbers {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;


        final int[] rows = new int[n];
        final int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0 || matrix[i][j] > rows[i]) {
                    rows[i] = matrix[i][j];
                }

                if (i == 0 || matrix[i][j] > cols[j]) {
                    cols[j] = matrix[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == rows[i] && rows[i] == cols[j]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
