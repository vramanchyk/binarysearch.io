package com.github.vramanchyk.bs;

import java.util.TreeMap;

/**
 * Created by Vitali Ramanchyk on 25.11.20.
 */
public class BS685_Costly_Flight_Of_Stairs {

    public int solve(int[] stairs, int k) {
        if (stairs == null || stairs.length == 0) {
            return 0;
        }

        final TreeMap<Integer, Integer> counts = new TreeMap<>();
        counts.put(stairs[0], 1);

        for (int index = 1; index < stairs.length; index++) {
            stairs[index] += counts.firstKey();

            if (index >= k) {
                counts.compute(stairs[index - k], (key, old) -> {
                    return old != null && old > 1 ? old - 1 : null;
                });
            }

            counts.compute(stairs[index], (key, old) -> {
                return old == null ? 1 : old + 1;
            });
        }

        return stairs[stairs.length - 1];
    }
}
