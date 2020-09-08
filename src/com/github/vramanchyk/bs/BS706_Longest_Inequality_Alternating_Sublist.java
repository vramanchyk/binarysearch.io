package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS706_Longest_Inequality_Alternating_Sublist {

    public int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        final int[][] dp = new int[n][2];

        dp[0][0] = dp[0][1] = 1;
        int answer = 1;

        for (int index = 1; index < n; index++) {
            dp[index][0] = nums[index] > nums[index - 1] ? dp[index - 1][1] + 1 : 1;
            dp[index][1] = nums[index] < nums[index - 1] ? dp[index - 1][0] + 1 : 1;
            answer = Math.max(answer, Math.max(dp[index][0], dp[index][1]));
        }

        return answer;
    }
}
