package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS002_Balanced_Brackets {

    public boolean solve(String s) {

        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    return false;
                }
            }
        }

        return open == 0;
    }
}
