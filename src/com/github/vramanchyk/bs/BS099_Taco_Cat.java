package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS099_Taco_Cat {

    public boolean solve(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
