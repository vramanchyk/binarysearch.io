package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/8/20.
 */
public class BS357_Longest_Alternating_Subsequence {

    public int solve(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        final int[][] dp = new int[n + 1][2];
        int answer = 1;
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[j] > nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }

                answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
            }
        }

        return answer;
    }
}
