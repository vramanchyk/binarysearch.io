package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS306_City_Blocks {

    public int solve(String[][] matrix, String[] blocks) {

        Map<String, int[]> positions = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                positions.put(matrix[i][j], new int[]{i, j});
            }
        }

        int x = 0, y = 0;
        int distance = 0;

        for (String block : blocks) {
            int[] pos = positions.get(block);
            distance += Math.abs(x - pos[0]) + Math.abs(y - pos[1]);
            x = pos[0];
            y = pos[1];
        }

        return distance;
    }
}
