package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS067_Set_Bits {

    private int getDim(int n) {
        int dim = 0;

        while (n > 0) {
            dim++;
            n /= 2;
        }

        return dim;
    }

    private int get(int bit, int n) {

        if (n == 0) {
            return 0;
        }

        if (bit == 0) {
            return n & 1;
        }

        if (((n >> bit) & 1) == 0) {
            return get(bit - 1, n);
        }

        final int zero = get(bit - 1, (1 << bit) - 1);
        n -= (1 << bit);

        return zero + n + 1 + get(bit - 1, n);
    }

    public int solve(int n) {
        return get(getDim(n) - 1, n);
    }
}
