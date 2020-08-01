package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/31/20.
 */
public class BS313_Remove_One_Letter {

    public boolean solve(String s0, String s1) {
        if (s0.length() - 1 != s1.length()) {
            return false;
        }

        int l0 = 0, l1 = 0;
        int mismatch = 0;
        while (l0 < s0.length() && l1 < s1.length()) {
            if (s0.charAt(l0) == s1.charAt(l1)) {
                l0++;
                l1++;
            } else {
                if (++mismatch > 1) {
                    return false;
                }
                l0++;
            }
        }

        return true;
    }
}
