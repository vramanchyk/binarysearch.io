package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/20/20.
 */
public class BS111_Austin_Powers {

    public boolean solve(int n) {
        if (n == 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
