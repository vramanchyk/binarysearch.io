package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS030_Compress_String {

    public String solve(String s) {
        char last = 0;

        StringBuilder bld = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != last) {
                bld.append(ch);
                last = ch;
            }
        }

        return bld.toString();
    }
}
