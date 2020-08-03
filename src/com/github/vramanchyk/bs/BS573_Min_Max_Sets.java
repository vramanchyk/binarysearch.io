package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/3/20.
 */
public class BS573_Min_Max_Sets {

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;

        int ans = 0;

        while (l <= r) {
            while (l <= r && nums[l] + nums[r] > k) {
                r--;
            }

            if (r < l) {
                break;
            }

            int cnt = r - l;
            ans += (1 << cnt);

            l++;
        }

        return ans;
    }
}
