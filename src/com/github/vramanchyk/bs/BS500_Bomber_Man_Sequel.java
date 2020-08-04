package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS500_Bomber_Man_Sequel {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        final int[] cols = new int[m];
        final int[][] down = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = (i + 1 < n ? down[i + 1][j] : 0) + (matrix[i][j] == 2 ? 1 : 0);
                }
            }
        }

        int answer = 0;
        int[] left = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    left[j] = 0;
                    cols[j] = 0;
                } else {
                    cols[j] += (matrix[i][j] == 2 ? 1 : 0);
                    left[j] = (j - 1 >= 0 ? left[j - 1] : 0) + (matrix[i][j] == 2 ? 1 : 0);
                }
            }

            int right = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right = 0;
                } else {
                    right += matrix[i][j] == 2 ? 1 : 0;

                    if (matrix[i][j] == 0) {
                        int count = right + left[j] + cols[j] + down[i][j];
                        answer = Math.max(answer, count);
                    }
                }
            }
        }

        return answer;
    }
}
