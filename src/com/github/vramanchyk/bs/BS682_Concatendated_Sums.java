package com.github.vramanchyk.bs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 8/29/20.
 */
public class BS682_Concatendated_Sums {

    private int dim(int n) {

        if (n == 0) {
            return 10;
        }

        int res = 1;
        while (n > 0) {
            res *= 10;
            n /= 10;
        }

        return res;
    }

    public int solve(int[] nums) {

        final Map<Integer, Integer> pow = new HashMap<>();
        for (int num : nums) {
            int dim = dim(num);
            pow.put(dim, pow.getOrDefault(dim, 0) + 1);
        }

        final int n = nums.length;
        int ans = 0;

        for (int num : nums) {
            ans += num * n;

            for (Map.Entry<Integer, Integer> en : pow.entrySet()) {
                ans += num * en.getKey() * en.getValue();
            }
        }

        return ans;
    }
}
