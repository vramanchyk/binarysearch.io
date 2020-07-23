package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS026_Longest_Palindromic_Subsequence {

    public int solve(String s) {
        final int n = s.length();

        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(max[i], -1);
        }

        max[0][0] = 1;

        for (int j = 1; j < n; j++) {
            max[j][j] = 1;
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    int mid = 0;
                    if (i + 1 <= j - 1) {
                        mid = max[i + 1][j - 1];
                    }

                    max[i][j] = Math.max(max[i][j], 2 + mid);
                }

                max[i][j] = Math.max(max[i][j], max[i][j - 1]);
            }
        }

        return max[n - 1][n - 1];
    }
}
