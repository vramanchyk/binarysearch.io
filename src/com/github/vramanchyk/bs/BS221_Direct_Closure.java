package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS221_Direct_Closure {

    public int[][] solve(int[][] graph) {
        final int n = graph.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            matrix[i][i] = 1;

            final int[] edge = graph[i];
            for (int j : edge) {
                matrix[i][j] = 1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        return matrix;
    }
}
