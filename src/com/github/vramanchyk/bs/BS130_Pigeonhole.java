package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS130_Pigeonhole {

    public int solve(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        final int n = nums.length - 1;
        return sum - (n * (n + 1) / 2);
    }
}
