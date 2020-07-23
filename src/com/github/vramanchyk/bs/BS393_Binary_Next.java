package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS393_Binary_Next {

    public int solve(int n) {
        int i = 0;
        int cnt = 0;
        for (; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                if (((n >> (i + 1)) & 1) == 0) {
                    break;
                }
                n -= (1 << i);
                cnt++;
            }
        }

        int suffix = (1 << cnt) - 1;
        return n - (1 << i) + (1 << (i + 1)) + suffix;
    }
}
