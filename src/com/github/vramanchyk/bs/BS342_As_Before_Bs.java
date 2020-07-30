package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS342_As_Before_Bs {

    public int solve(String s) {
        final int n = s.length();

        int suffix = 0;
        int prefix = 0;

        for (char ch : s.toCharArray()) {
            suffix += ch == 'A' ? 1 : 0;
        }

        int deletion = n;
        for (char ch : s.toCharArray()) {
            deletion = Math.min(deletion, prefix + suffix);
            prefix += ch == 'B' ? 1 : 0;
            suffix -= ch == 'A' ? 1 : 0;
        }

        return Math.min(deletion, prefix);
    }
}
