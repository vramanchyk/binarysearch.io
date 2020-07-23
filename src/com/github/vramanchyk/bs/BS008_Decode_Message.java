package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/17/20.
 */
public class BS008_Decode_Message {

    private int findSolution(int offset, String str, int[] dp) {
        if (dp[offset] != -1) {
            return dp[offset];
        }

        if (offset >= str.length()) {
            return 1;
        }

        final char ch = str.charAt(offset);
        if (ch == 0) {
            return 0;
        }

        int cur = findSolution(offset + 1, str, dp);
        ;

        if (ch == '1') {

            if (offset + 1 < str.length()) {
                cur += findSolution(offset + 2, str, dp);
            }

        } else if (ch == '2') {

            if (offset + 1 < str.length()) {
                final char next = str.charAt(offset + 1);
                if (next <= '6') {
                    cur += findSolution(offset + 2, str, dp);
                }
            }

        }

        return dp[offset] = cur;
    }

    public int solve(String message) {
        final int[] dp = new int[message.length() + 1];
        Arrays.fill(dp, -1);
        return findSolution(0, message, dp);
    }
}
