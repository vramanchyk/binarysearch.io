package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS021_Subsequence_Strings {

    public boolean solve(String s1, String s2) {
        int cursor = 0;

        final int len2 = s2.length();
        for (char ch : s1.toCharArray()) {

            while (cursor < len2 && s2.charAt(cursor) != ch) {
                cursor++;
            }

            if (cursor >= len2) {
                return false;
            }

            cursor++;
        }

        return true;
    }
}
