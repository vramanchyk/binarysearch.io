package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/6/20.
 */
public class BS170_Factorial_Factory {

    public int solve(int n) {
        return n < 2 ? 1 : n * solve(n - 1);
    }
}
