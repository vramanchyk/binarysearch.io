package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS265_The_Auditor {

    public int solve(String s) {

        int column = 0;
        for (char ch : s.toCharArray()) {
            column = column * 26 + (ch - 'A') + 1;
        }

        return column;
    }
}
