package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS569_Chain_Of_Blocks {

    public int solve(int[][] blocks) {
        Arrays.sort(blocks, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        final Map<Integer, Integer> map = new HashMap<>();
        for (int[] block : blocks) {
            int len = map.getOrDefault(block[0], 0);
            int val = map.getOrDefault(block[1], 0);
            map.put(block[1], Math.max(val, len + 1));
        }

        int max = 0;
        for (Integer v : map.values()) {
            max = Math.max(max, v);
        }

        return max;
    }
}
