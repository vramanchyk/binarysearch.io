package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS588_Bus_Stop {

    public int solve(int[] nums) {

        int n = nums.length;
        final int[] times = new int[n];

        int bus = 0;
        while (n > 0) {

            int cur = 0;
            int last = nums[0];

            bus++;

            for (int index = 1; index < n; index++) {
                if (nums[index] <= last) {
                    times[cur++] = nums[index];
                } else {
                    last = nums[index];
                }
            }

            n = cur;
            nums = times;
        }

        return bus;
    }
}
