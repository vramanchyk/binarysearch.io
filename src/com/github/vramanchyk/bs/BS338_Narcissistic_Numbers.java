package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/12/20.
 */
public class BS338_Narcissistic_Numbers {

    private int len(int n) {
        int len = 0;

        while (n > 0) {
            len++;
            n /= 10;
        }

        return len;
    }

    public boolean solve(int n) {
        int tmp = n;
        int sum = 0;
        final int len = len(n);

        while (tmp > 0) {
            sum += Math.pow(tmp % 10, len);
            tmp /= 10;
        }

        return sum == n;
    }
}
