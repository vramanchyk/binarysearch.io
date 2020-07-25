package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/25/20.
 */
public class BS098_Interleaved_Strings {

    public String solve(String s0, String s1) {
        StringBuilder bld = new StringBuilder();

        int cur0 = 0, cur1 = 0;
        while (cur0 < s0.length() && cur1 < s1.length()) {
            bld.append(s0.charAt(cur0++));
            bld.append(s1.charAt(cur1++));
        }

        while (cur0 < s0.length()) {
            bld.append(s0.charAt(cur0++));
        }

        while (cur1 < s1.length()) {
            bld.append(s1.charAt(cur1++));
        }

        return bld.toString();
    }
}
