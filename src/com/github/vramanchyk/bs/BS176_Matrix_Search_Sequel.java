package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS176_Matrix_Search_Sequel {

    public boolean solve(int[][] matrix, int target) {
        final int n = matrix.length;

        if (n == 0) {
            return false;
        }

        final int m = matrix[0].length;

        if (m == 0) {
            return false;
        }

        int r = n - 1;
        int c = 0;

        while (r >= 0 && c < m) {
            if (matrix[r][c] == target) {
                return true;
            }

            if (target > matrix[r][c]) {
                c++;
            } else {
                r--;
            }
        }

        return false;
    }
}
