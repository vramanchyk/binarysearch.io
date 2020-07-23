package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS025_Unique_Occurrences {

    public boolean solve(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        final long unique = counts.values().stream().distinct().count();
        return counts.size() == unique;
    }
}
