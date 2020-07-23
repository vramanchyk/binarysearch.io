package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS488_Flipped_Matrix {

    public int solve(int[][] matrix) {
        int[] toggle = new int[matrix.length];

        for (int col = 0; col < matrix[0].length; col++) {
            int zeros = 0, ones = 0;

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] ^= toggle[row];
                if (matrix[row][col] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }

            if (zeros > ones) {
                for (int row = 0; row < matrix.length; row++) {
                    if ((matrix[row][col] ^ toggle[row]) == 0) {
                        matrix[row][col] = 1;
                    }
                }
            }

            if (col == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    if (matrix[row][col] == 0) {
                        matrix[row][col] = 1;
                        toggle[row] = 1;
                    }
                }
            }
        }

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int cur = 0;

            for (int col = 0; col < matrix[0].length; col++) {
                cur = (cur << 1) + matrix[row][col];
            }

            sum += cur;
        }

        return sum;
    }
}
