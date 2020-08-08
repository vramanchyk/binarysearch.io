package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS217_Longest_Common_Subsequence_Of_Three_Strings {

    public int solve(String a, String b, String c) {
        final int n = a.length();
        final int m = b.length();
        final int k = c.length();

        final int[][][] dp = new int[n + 1][m + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int q = 0; q <= k; q++) {

                    if (i == 0 || j == 0 || q == 0) {
                        dp[i][j][q] = 0;
                    } else {

                        final char ca = a.charAt(i - 1);
                        final char cb = b.charAt(j - 1);
                        final char cc = c.charAt(q - 1);

                        if (ca == cb && cb == cc) {
                            dp[i][j][q] = dp[i - 1][j - 1][q - 1] + 1;
                        }

                        dp[i][j][q] = Math.max(
                                dp[i][j][q],
                                Math.max(
                                        dp[i][j][q - 1],
                                        Math.max(dp[i][j - 1][q], dp[i - 1][j][q])
                                )
                        );
                    }
                }
            }
        }

        return dp[n][m][k];
    }
}
