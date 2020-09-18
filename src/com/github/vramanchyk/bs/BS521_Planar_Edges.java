package com.github.vramanchyk.bs;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

/**
 * Created by Vitali Ramanchyk on 9/18/20.
 */
public class BS521_Planar_Edges {

    private final int INF = 1_000_000_007;

    private BigInteger Cnk(int n, int k) {
        BigInteger res = BigInteger.ONE;

        for (int i = 0; i < k; i++) {
            res = res.multiply(valueOf(n - i)).divide(valueOf(i + 1));
        }

        return res;
    }

    public int solve(int n) {
        n /= 2;
        return Cnk(2 * n, n).divide(valueOf(n + 1)).mod(valueOf(INF)).intValue();
    }
}
