package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/16/20.
 */
public class BS650_Largest_Sum_Of_3 {

    private int[] getSums(int[] nums, int k) {

        final int n = nums.length;
        final int[] sums = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum -= i >= k ? nums[i - k] : 0;
            sums[i] = i >= k - 1 ? sum : 0;
        }

        return sums;
    }

    public int solve(int[] nums, int k) {

        if (nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        final int[] sums = getSums(nums, k);
        final int[][] dp = new int[n][3];

        for (int l = 0; l < 3; l++) {
            for (int i = (l + 1) * k - 1; i < n; i++) {
                dp[i][l] = (l > 0 ? dp[i - k][l - 1] : 0) + sums[i];
                if (i >= (l + 1) * k) {
                    dp[i][l] = Math.max(dp[i][l], dp[i - 1][l]);
                }
            }
        }

        int ans = dp[3 * k - 1][2];
        for (int i = 3 * k - 1; i < n; i++) {
            ans = Math.max(ans, dp[i][2]);
        }

        return ans;
    }
}
