package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS431_Split_Product {

    public int solve(int n) {
        int pow3 = n / 3;
        if (n % 3 == 1) {
            pow3--;
        }

        int mul3 = 1;
        for (int pow = 1; pow <= pow3; pow++) {
            mul3 *= 3;
        }

        n -= pow3 * 3;
        int pow2 = n / 2;

        int mul2 = 1;
        for (int pow = 1; pow <= pow2; pow++) {
            mul2 *= 2;
        }

        return mul3 * mul2;
    }
}
