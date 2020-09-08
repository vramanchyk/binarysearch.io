package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS102_Removing_Parentheses {

    public int solve(String s) {

        int maxLen = 0;
        int openCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    maxLen += 2;
                    openCount--;
                }
            }
        }

        return s.length() - maxLen;
    }
}
