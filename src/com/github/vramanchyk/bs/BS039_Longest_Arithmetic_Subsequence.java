package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/16/20.
 */
public class BS039_Longest_Arithmetic_Subsequence {

    public int solve(int[] nums) {

        final int len = nums.length;
        final List<Map<Integer, Integer>> dp = new ArrayList<>();

        int result = 0;
        for (int index = 0; index < len; index++) {
            final Map<Integer, Integer> cur = new HashMap<>();
            cur.put(0, 1);
            result = Math.max(result, 1);

            for (int last = index - 1; last >= 0; last--) {
                final int diff = nums[index] - nums[last];
                final int lastLen = dp.get(last).getOrDefault(diff, 1);

                final int curLen = lastLen + 1;
                final int curMax = Math.max(curLen, cur.getOrDefault(diff, 0));
                cur.put(diff, curMax);
                result = Math.max(result, curMax);

            }

            dp.add(cur);
        }

        return result;
    }
}
