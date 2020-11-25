package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 25.11.20.
 */
public class BS053_Zipped_String {

    public boolean solve(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) {
            return false;
        }

        final int n = a.length();
        final int m = b.length();
        final int len = c.length();

        final boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int l = 1; l <= len; l++) {
            for (int la = 0; la <= n; la++) {
                int lb = l - la;

                if (lb > m || lb < 0) {
                    continue;
                }

                if (lb > 0) {
                    if (c.charAt(l - 1) == b.charAt(lb - 1)) {
                        dp[la][lb] |= dp[la][lb - 1];
                    }
                }
                if (la > 0) {
                    if (c.charAt(l - 1) == a.charAt(la - 1)) {
                        dp[la][lb] |= dp[la - 1][lb];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
