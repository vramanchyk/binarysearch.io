package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS531_Scrum_Grandmaster {

    public int solve(int[] nums) {
        final int n = nums.length;
        final int[][] dp = new int[n][2];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            dp[i][0] = (i > 0 ? dp[i - 1][1] : 0) + nums[i];
            if (i > 1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][0] + nums[i]);
            }

            if (i > 0) {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        return sum - Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
