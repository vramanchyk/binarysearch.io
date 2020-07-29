package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS423_Coprime_Suspects {

    private int gcd(int a, int b) {

        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;

        while (a > 0 && b > 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        return a + b;
    }

    public int solve(int a, int b) {
        int min = Math.max(a, b);

        if (gcd(a, b) != 1) {
            return 0;
        }

        if (gcd(a - 1, b) != 1 || gcd(a + 1, b) != 1) {
            return 1;
        }

        if (gcd(a, b - 1) != 1 || gcd(a, b + 1) != 1) {
            return 1;
        }

        return 2;
    }
}
