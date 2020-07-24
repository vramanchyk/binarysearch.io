package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS123_Sudoki_Validator {

    public boolean solve(int[][] matrix) {

        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int dig = matrix[row][col] - 1;

                rows[row] |= (1 << dig);
                cols[col] |= (1 << dig);
                squares[(row / 3) * 3 + col / 3] |= (1 << dig);
            }
        }

        int target = (1 << 9) - 1;

        for (int idx = 0; idx < 9; idx++) {
            if (rows[idx] != target || cols[idx] != target || squares[idx] != target) {
                return false;
            }
        }

        return true;
    }
}
