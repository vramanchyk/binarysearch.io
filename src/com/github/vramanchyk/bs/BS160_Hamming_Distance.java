package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS160_Hamming_Distance {

    public int solve(int x, int y) {
        int xor = x ^ y;

        int dist = 0;
        while (xor > 0) {
            dist += xor & 1;
            xor >>= 1;
        }

        return dist;
    }
}
