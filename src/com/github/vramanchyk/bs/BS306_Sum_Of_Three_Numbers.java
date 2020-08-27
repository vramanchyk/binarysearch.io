package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/27/20.
 */
public class BS306_Sum_Of_Three_Numbers {

    private boolean find(int l, int[] nums, int k) {
        int r = nums.length - 1;

        while (l < r) {
            final int target = nums[l] + nums[r];

            if (target == k) {
                return true;
            }

            if (target > k) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }

    public boolean solve(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (find(i + 1, nums, k - nums[i])) {
                return true;
            }
        }

        return false;
    }
}
