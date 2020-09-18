package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/18/20.
 */
public class BS346_Grouper {

    public int solve(String s) {
        if (s.length() == 0) {
            return 0;
        }

        final int n = s.length();
        final int[] dp = new int[n];
        final char[] c = s.toCharArray();

        int rightOnes = 0;
        int rightShift = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (c[i] == '0') {
                rightShift += rightOnes;
            } else {
                rightOnes++;
            }

            dp[i] = rightShift;
        }

        int minShift = -1;

        int leftOnes = 0;
        int leftShift = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == '0') {
                leftShift += leftOnes;
            } else {
                leftOnes++;
            }

            int shift = leftShift + (i + 1 < n ? dp[i + 1] : 0);

            if (minShift < 0 || shift < minShift) {
                minShift = shift;
            }
        }

        return minShift;
    }
}
