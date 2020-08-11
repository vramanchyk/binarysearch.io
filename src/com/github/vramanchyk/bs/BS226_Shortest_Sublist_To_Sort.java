package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/10/20.
 */
public class BS226_Shortest_Sublist_To_Sort {

    public int solve(int[] nums) {
        final int n = nums.length;

        int l = 0;
        while (l < n - 1 && nums[l] < nums[l + 1]) {
            l++;
        }

        if (l == n - 1) {
            return 0;
        }

        int r = n - 1;
        while (r > 0 && nums[r - 1] < nums[r]) {
            r--;
        }

        int min = nums[l];
        int max = nums[l];

        for (int idx = l + 1; idx <= r; idx++) {
            min = Math.min(min, nums[idx]);
            max = Math.max(max, nums[idx]);
        }

        for (int idx = 0; idx < l; idx++) {
            if (nums[idx] > min) {
                l = idx;
            }
        }

        for (int idx = n - 1; idx > r; idx--) {
            if (nums[idx] < max) {
                r = idx;
            }
        }

        return r - l + 1;
    }
}
