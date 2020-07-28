package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS412_Reflected_Binary_Code {

    public int solve(int n) {
        return n ^ (n / 2);
    }
}
