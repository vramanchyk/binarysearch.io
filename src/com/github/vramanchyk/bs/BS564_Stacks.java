package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS564_Stacks {

    public int solve(int[][] stacks) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int[] stack : stacks) {
            int sum = 0;
            for (int num : stack) {
                sum += num;
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> en : counts.entrySet()) {
            if (en.getValue() == stacks.length) {
                max = Math.max(max, en.getKey());
            }
        }

        return max;
    }
}
