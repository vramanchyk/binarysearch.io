package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/5/20.
 */
public class BS312_Inverse_Factorial {

    public int solve(int a) {
        if (a == 1) {
            return 1;
        }

        int f = 1;
        while (a % f == 0) {
            a /= f++;
        }

        return a == 1 ? f - 1 : -1;
    }
}
