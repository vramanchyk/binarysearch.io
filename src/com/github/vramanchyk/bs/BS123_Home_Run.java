package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS123_Home_Run {

    public int solve(int n) {
        int curCnt = 0;
        int maxCnt = 0;

        while (n > 0) {
            int bit = n & 1;
            if (bit == 0) {
                maxCnt = Math.max(maxCnt, curCnt);
                curCnt = 0;
            } else {
                curCnt++;
            }
            n >>= 1;
        }

        return Math.max(maxCnt, curCnt);
    }
}
