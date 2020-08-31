package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/31/20.
 */
public class BS412_Sum_Of_Four_Numbers {

    private boolean find(int l, int r, int[] nums, int k) {
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }

    public boolean solve(int[] nums, int k) {

        if (nums.length < 4) {
            return false;
        }

        Arrays.sort(nums);

        final int n = nums.length;
        for (int l = 0; l < n; l++) {
            for (int r = l + 3; r < n; r++) {
                if (nums[l] + nums[r] > k) {
                    break;
                }

                if (find(l + 1, r - 1, nums, k - nums[l] - nums[r])) {
                    return true;
                }
            }
        }

        return false;
    }
}
