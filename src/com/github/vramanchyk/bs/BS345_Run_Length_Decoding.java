package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/6/20.
 */
public class BS345_Run_Length_Decoding {

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public String solve(String s) {
        int cursor = 0;
        StringBuilder bld = new StringBuilder();

        while (cursor < s.length()) {

            int count = 0;
            while (cursor < s.length() && isDigit(s.charAt(cursor))) {
                count = count * 10 + s.charAt(cursor++) - 48;
            }

            final char ch = s.charAt(cursor++);

            while (count-- > 0) {
                bld.append(ch);
            }
        }

        return bld.toString();
    }
}
