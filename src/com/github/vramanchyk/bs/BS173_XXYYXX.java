package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/11/20.
 */
public class BS173_XXYYXX {

    public int solve(String s) {
        int rX = 0;

        int cY = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'x') {
                rX++;
            } else {
                cY++;
            }
        }

        int swaps = Math.min(rX, cY);

        int lY = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'y') {
                swaps = Math.min(swaps, lY + rX);
                lY++;
            }

            if (ch == 'x') {
                rX--;
            }
        }

        return swaps;
    }
}
