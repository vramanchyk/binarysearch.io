package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS128_Pascals_Triangle {

    public int[] solve(int n) {
        final int[][] result = new int[2][n + 1];

        int current = 1;
        int previous = 0;

        result[previous][0] = 1;

        for (int row = 1; row <= n; row++) {

            for (int column = 0; column <= row; column++) {
                int prevValue = column > 0 ? result[previous][column - 1] : 0;
                result[current][column] = result[previous][column] + prevValue;
            }

            current ^= 1;
            previous ^= 1;
        }

        return result[previous];
    }

}
