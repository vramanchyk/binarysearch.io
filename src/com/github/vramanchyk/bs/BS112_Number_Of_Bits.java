package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS112_Number_Of_Bits {

    public int solve(int n) {
        int count = 0;

        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}
