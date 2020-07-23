package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS101_An_Anagram_I_Am {

    public boolean solve(String s0, String s1) {

        if (s0.length() != s1.length()) {
            return false;
        }

        final char[] c0 = s0.toCharArray();
        final char[] c1 = s1.toCharArray();

        Arrays.sort(c0);
        Arrays.sort(c1);

        for (int index = 0; index < c0.length; index++) {
            if (c0[index] != c1[index]) {
                return false;
            }
        }

        return true;
    }
}
