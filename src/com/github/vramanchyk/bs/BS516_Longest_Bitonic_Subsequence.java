package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/2/20.
 */
public class BS516_Longest_Bitonic_Subsequence {

    private int inc(int max, int target, int[] values) {
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
        int[] left = new int[n];
        int[] right = new int[n];

        int[] maxInc = new int[n];

        int max = 0;
        for (int index = 0; index < n; index++) {
            int len = inc(max, nums[index], left);
            if (len >= max) {
                left[max++] = nums[index];
            } else if (nums[index] < left[len]) {
                left[len] = nums[index];
            }

            maxInc[index] = len + 1;
        }

        int answer = 0;
        int maxRight = 0;
        for (int index = n - 1; index >= 0; index--) {
            int len = inc(maxRight, nums[index], right);
            if (len >= maxRight) {
                right[maxRight++] = nums[index];
            } else if (nums[index] < right[len]) {
                right[len] = nums[index];
            }

            answer = Math.max(answer, maxInc[index] + len);
        }

        return answer;
    }
}
