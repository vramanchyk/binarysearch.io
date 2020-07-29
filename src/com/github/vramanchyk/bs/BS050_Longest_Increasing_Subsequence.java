package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS050_Longest_Increasing_Subsequence {

    private int find(int max, int target, int[] values) {

        int l = 0, r = max - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (values[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public int solve(int[] nums) {
        final int n = nums.length;
        final int[] values = new int[n];

        int max = 0;

        for (int num : nums) {
            int len = find(max, num, values);
            if (len == max) {
                values[max++] = num;
            } else if (num < values[len]) {
                values[len] = num;
            }
        }

        return max;
    }
}
