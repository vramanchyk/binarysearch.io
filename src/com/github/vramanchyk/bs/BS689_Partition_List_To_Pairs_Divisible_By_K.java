package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/19/20.
 */
public class BS689_Partition_List_To_Pairs_Divisible_By_K {
    public boolean solve(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        if (nums.length % 2 != 0) {
            return false;
        }

        if (k == 1) {
            return true;
        }

        for (int index = 0; index < nums.length; index++) {
            nums[index] %= k;
        }

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        while (l < nums.length && nums[l] == 0) {
            l++;
        }

        if (l % 2 != 0) {
            return false;
        }

        while (l < r) {
            if ((nums[l] + nums[r]) % k != 0) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
