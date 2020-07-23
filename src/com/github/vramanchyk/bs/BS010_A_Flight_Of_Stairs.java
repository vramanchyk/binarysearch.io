package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS010_A_Flight_Of_Stairs {

    private final int MOD = 1_000_000_007;

    public int solve(int n) {
        if (n < 2) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1, b = 2;
        for (int step = 2; step < n; step++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }

        return b;
    }
}
