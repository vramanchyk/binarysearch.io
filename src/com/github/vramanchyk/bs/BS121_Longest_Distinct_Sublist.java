package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS121_Longest_Distinct_Sublist {

    public int solve(int[] nums) {
        Map<Integer, Integer> positions = new HashMap<>();

        int l = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            int last = positions.getOrDefault(nums[r], -1);

            if (last != -1) {
                max = Math.max(max, r - Math.max(l, last + 1) + 1);
                l = Math.max(l, last + 1);
            } else {
                max = Math.max(max, r - l + 1);
            }

            positions.put(nums[r], r);
        }

        return max;
    }
}
