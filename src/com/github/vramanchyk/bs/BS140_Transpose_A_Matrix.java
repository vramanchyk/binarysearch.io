package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS140_Transpose_A_Matrix {

    public int[][] solve(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int column = row + 1; column < matrix[0].length; column++) {
                int tmp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = tmp;
            }
        }
        return matrix;
    }
}
