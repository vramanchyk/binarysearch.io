package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS008_Decode_Message {

    public int solve(String message) {
        final int n = message.length();
        final int[] dp = new int[n + 1];
        dp[0] = 1;

        int last = 0;
        for (int index = 1; index <= n; index++) {
            final int ch = message.charAt(index - 1) - 48;

            if (ch != 0) {
                dp[index] = dp[index - 1];

                if (index > 1 && last != 0 && last * 10 + ch <= 26) {
                    dp[index] += dp[index - 2];
                }

            } else {
                if (index == 1) {
                    return 0;
                }

                if (last != 0 && last * 10 + ch <= 26) {
                    dp[index] = dp[index - 2];
                } else {
                    return 0;
                }
            }

            last = ch;
        }

        return dp[n];
    }
}
