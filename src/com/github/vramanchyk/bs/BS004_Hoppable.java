package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS004_Hoppable {

    public boolean solve(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        int l = 0;

        while (l < nums.length) {

            int r = nums[l];

            if (l + r >= nums.length - 1) {
                return true;
            }

            int maxIdx = -1;
            int maxValue = -1;

            for (int idx = l + 1; idx <= l + r; idx++) {
                if (idx + nums[idx] > maxValue) {
                    maxValue = idx + nums[idx];
                    maxIdx = idx;
                }
            }

            if (maxValue < r) {
                return false;
            }

            l = maxIdx;
        }

        return false;
    }
}