package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS009_Largest_Sum_Of_Non_Adjacent_Numbers {

    public int solve(int[] nums) {
        final int n = nums.length;
        final int[][] dp = new int[n][2];

        for (int index = 0; index < n; index++) {
            dp[index][0] = nums[index] + Math.max(
                    index > 1 ? dp[index - 2][0] : 0,
                    index > 0 ? dp[index - 1][1] : 0
            );

            dp[index][1] = index > 0 ? Math.max(
                    dp[index - 1][0],
                    dp[index - 1][1]
            ) : 0;
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
