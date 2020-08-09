package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/9/20.
 */
public class BS210_PHP_Convention {

    public boolean solve(int n, int[] convention) {
        if (n == 0) {
            return true;
        }

        int cnt = 0;
        final int len = convention.length;
        for (int idx = 0; idx < len; idx++) {
            if (convention[idx] == 0) {
                final boolean prev = idx == 0 || convention[idx - 1] == 0;
                final boolean next = idx + 1 == len || convention[idx + 1] == 0;
                if (prev && next) {
                    convention[idx] = 1;
                    if (--n == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
