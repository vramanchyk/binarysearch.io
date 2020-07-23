package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS032_One_Edit_Distance {

    private boolean checkReplace(String s1, String s2) {
        int fix = 0;
        for (int index = 0; index < s1.length(); index++) {
            if (s1.charAt(index) != s2.charAt(index)) {
                if (++fix > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkAdd(String s1, String s2) {
        int skip = 0;
        while (skip < s1.length() && s1.charAt(skip) == s2.charAt(skip)) {
            skip++;
        }

        while (skip < s1.length()) {
            if (s1.charAt(skip) != s2.charAt(skip + 1)) {
                return false;
            }
            skip++;
        }

        return true;
    }

    public boolean solve(String s0, String s1) {

        if (Math.abs(s0.length() - s1.length()) > 1) {
            return false;
        }

        if (s0.length() == s1.length()) {
            return checkReplace(s0, s1);
        }

        if (s0.length() < s1.length()) {
            return checkAdd(s0, s1);
        }

        return checkAdd(s1, s0);
    }
}
