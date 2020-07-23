package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS205_Longest_Common_Substring {

    public int solve(String s0, String s1) {
        final int n = s0.length();
        final int m = s1.length();

        int[][] max = new int[2][m + 1];

        int ans = 0;
        int cur = 0, prev = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s0.charAt(i - 1) == s1.charAt(j - 1)) {
                    max[cur][j] = max[prev][j - 1] + 1;
                    ans = Math.max(ans, max[cur][j]);
                } else {
                    max[cur][j] = 0;
                }
            }

            cur ^= 1;
            prev ^= 1;
        }

        return ans;
    }
}
