package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS601_Grammar_Rules {

    private final int MOD = 1_000_000_007;

    private int sum(int... values) {
        int res = 0;

        for (int val : values) {
            res = (res + val) % MOD;
        }

        return res;
    }

    public int solve(int n) {

        if (n == 0) {
            return 0;
        }

        int prevA = 1, prevE = 1, prevI = 1, prevO = 1, prevU = 1;
        for (int t = 1; t < n; t++) {
            int curA = sum(prevE, prevI, prevU);
            int curE = sum(prevA, prevI);
            int curI = sum(prevE, prevO);
            int curO = prevI;
            int curU = sum(prevO, prevI);

            prevA = curA;
            prevE = curE;
            prevI = curI;
            prevO = curO;
            prevU = curU;
        }

        return sum(prevA, prevE, prevI, prevO, prevU);
    }
}
