package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS052_A_Man_A_Plan_A_Canal {

    private boolean is(int l, int r, boolean[][] palindrome) {
        return l >= r || palindrome[l][r];
    }

    public int solve(String s) {
        final int n = s.length();
        final boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                if (s.charAt(i) == s.charAt(i + len)) {
                    palindrome[i][i + len] |= is(i + 1, i + len - 1, palindrome);
                }
            }
        }

        int[] split = new int[s.length() + 1];
        Arrays.fill(split, Integer.MAX_VALUE);
        split[0] = 0;

        for (int i = 0; i < n; i++) {
            if (split[i] != Integer.MAX_VALUE) {
                for (int j = 0; j < n; j++) {
                    if (palindrome[i][j]) {
                        split[j + 1] = Math.min(split[j + 1], split[i] + 1);
                    }
                }
            }
        }

        return split[n];
    }
}
