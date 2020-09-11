package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/11/20.
 */
public class BS015_Tom_Sawyer {

    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int n = matrix.length;
        final int m = matrix[0].length;

        for (int fence = 1; fence < n; fence++) {

            for (int color = 0; color < m; color++) {

                int minColor = -1;

                for (int prevColor = 0; prevColor < m; prevColor++) {
                    if (color != prevColor) {

                        if (minColor == -1 || matrix[fence - 1][prevColor] < minColor) {
                            minColor = matrix[fence - 1][prevColor];
                        }
                    }
                }

                matrix[fence][color] += minColor;
            }
        }

        int minCost = matrix[n - 1][0];
        for (int color = 1; color < m; color++) {
            minCost = Math.min(minCost, matrix[n - 1][color]);
        }

        return minCost;
    }
}
