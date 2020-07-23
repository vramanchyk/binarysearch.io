package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS170_Triangle_Stairs {

    public String solve(int n) {

        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < n; i++) {

            if (i > 0) {
                bld.append('\n');
            }

            for (int sp = 0; sp < n - i - 1; sp++) {
                bld.append(' ');
            }

            for (int st = 0; st < i + 1; st++) {
                bld.append('*');
            }
        }

        return bld.toString();
    }
}
