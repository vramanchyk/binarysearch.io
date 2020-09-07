package com.github.vramanchyk.bs;

import java.util.stream.IntStream;

/**
 * Created by Vitali Ramanchyk on 9/7/20.
 */
public class BS565_Equalize_Lists {

    private int get(int target, int[] nums, int[] costs) {
        int result = 0;

        for (int index = 0; index < nums.length; index++) {
            result += Math.abs(nums[index] - target) * costs[index];
        }

        return result;
    }

    public int solve(int[] nums, int[] costs) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0, r = 0;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        int cost = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            int cur = get(m, nums, costs);
            cost = cost == -1 ? cur : Math.min(cost, cur);

            if (cur > get(m + 1, nums, costs)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return cost;
    }
}
