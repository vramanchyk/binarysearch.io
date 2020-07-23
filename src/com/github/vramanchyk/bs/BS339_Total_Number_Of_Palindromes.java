package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS339_Total_Number_Of_Palindromes {

    public int solve(String s) {
        final int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            dp[i][i] = true;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                if (s.charAt(i) == s.charAt(i + len)) {
                    if (dp[i][i + len] |= (len == 1 || dp[i + 1][i + len - 1])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
