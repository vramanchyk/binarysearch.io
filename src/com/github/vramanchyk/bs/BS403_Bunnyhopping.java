package com.github.vramanchyk.bs;

import java.util.TreeMap;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS403_Bunnyhopping {

    public int solve(int[] nums, int k) {
        final TreeMap<Integer, Integer> counts = new TreeMap<>();

        final int n = nums.length;
        final int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            final Integer min = counts.isEmpty() ? null : counts.firstKey();
            if (min == null) {
                dp[i] = nums[i];
            } else {
                dp[i] = min + nums[i];
            }

            if (i >= k) {
                int count = counts.get(dp[i - k]);
                if (count == 1) {
                    counts.remove(dp[i - k]);
                } else {
                    counts.put(dp[i - k], count - 1);
                }
            }

            counts.put(dp[i], counts.getOrDefault(dp[i], 0) + 1);
        }

        return dp[n - 1];
    }
}
