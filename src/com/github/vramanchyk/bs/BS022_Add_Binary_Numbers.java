package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS022_Add_Binary_Numbers {

    public String solve(String a, String b) {
        final int lenA = a.length();
        final int lenB = b.length();

        final int len = Math.max(lenA, lenB);

        StringBuilder bld = new StringBuilder();

        int over = 0;
        for (int i = 0; i < len; i++) {
            int bitA = i >= lenA ? 0 : a.charAt(lenA - i - 1) - '0';
            int bitB = i >= lenB ? 0 : b.charAt(lenB - i - 1) - '0';
            int bit = (bitA + bitB + over) % 2;
            over = (bitA + bitB + over) / 2;
            bld.append((char) (bit + '0'));
        }

        if (over > 0) {
            bld.append('1');
        }

        return bld.reverse().toString();
    }
}
