package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS503_Distance_Pair {

    public int solve(int[] nums) {

        final int n = nums.length;
        final int[] max = new int[n];

        for (int j = n - 1; j >= 0; j--) {
            max[j] = nums[j] - j;
            if (j + 1 < n) {
                max[j] = Math.max(max[j], max[j + 1]);
            }
        }

        int ans = nums[0] + max[1];
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, nums[i] + i + max[i + 1]);
        }

        return ans;
    }
}
