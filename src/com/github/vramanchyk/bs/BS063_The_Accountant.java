package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS063_The_Accountant {

    public String solve(int n) {
        StringBuilder bld = new StringBuilder();

        while (n > 0) {
            int dig = ((--n % 26) + 26) % 26;
            bld.append((char) ('A' + dig));
            n /= 26;
        }

        return bld.reverse().toString();
    }
}
