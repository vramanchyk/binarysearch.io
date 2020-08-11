package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS632_K_Divisible_Sublist {

    public boolean solve(int[] nums, int k) {

        if (k == 0) {
            return false;
        }

        final Map<Integer, Integer> remainders = new HashMap<>();
        final Map<Integer, Integer> duplicates = new HashMap<>();

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum = (sum + num) % k;

            if (sum == 0 && count > 0) {
                return true;
            }

            if (remainders.putIfAbsent(sum, count) != null) {
                duplicates.put(sum, count);
            }

            count++;
        }

        for (Map.Entry<Integer, Integer> en : remainders.entrySet()) {
            final int rem = en.getKey();
            int remOffset = en.getValue();
            Integer dupOffset = duplicates.get(rem);

            if (dupOffset != null && dupOffset - remOffset > 1) {
                return true;
            }
        }

        return false;
    }
}
