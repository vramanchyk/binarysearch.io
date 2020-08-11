package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/11/20.
 */
public class BS514_Longest_Balanced_Subsequence {

    public int solve(String s) {

        int open = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                    count += 2;
                }
            }
        }

        return count;
    }
}
