package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS181_Astronomical_Number_Of_Binary_Search_Trees {

    private final int MOD = 1_000_000_007;

    private int mul(int a, int b) {
        int result = 0;

        a %= MOD;

        while (b > 0) {

            if (b % 2 != 0) {
                result = (result + a) % MOD;
            }

            b /= 2;
            a = (a + a) % MOD;
        }

        return result;
    }

    private int find(int n, int[] dp) {
        if (n < 2) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int current = 0;
        for (int l = 0; l <= n - 1; l++) {
            int lt = find(l, dp);
            int rt = find(n - 1 - l, dp);

            current = (current + mul(lt, rt)) % MOD;
        }

        return dp[n] = current;
    }

    public int solve(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return find(n, dp);
    }
}
