package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS271_Number_Of_Hops {

    public int solve(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int l = 0, r = 0;

        int hops = 0;
        while (l < nums.length) {
            hops++;
            r = nums[l];

            if (l + r >= nums.length - 1) {
                break;
            }

            int maxValue = -1;
            int maxIndex = -1;
            for (int idx = l + 1; idx <= l + r; idx++) {
                if (idx + nums[idx] > maxValue) {
                    maxValue = idx + nums[idx];
                    maxIndex = idx;
                }
            }

            l = maxIndex;
        }

        return hops;
    }
}
