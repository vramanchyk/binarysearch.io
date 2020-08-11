package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS179_Contiguous_Strictly_Increasing {

    public int solve(int[] nums) {
        final int n = nums.length;

        if (n == 0) {
            return 0;
        }

        final int[][] dp = new int[n][2];

        dp[0][0] = 1;

        int answer = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;

            if (nums[i - 1] < nums[i]) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (i - 2 >= 0 && nums[i - 2] < nums[i]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 2][0] + 1);
            }

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        return answer;
    }
}
