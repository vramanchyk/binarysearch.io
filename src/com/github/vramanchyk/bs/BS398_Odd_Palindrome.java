package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS398_Odd_Palindrome {

    public boolean solve(String s) {
        char last = 0;

        for (char ch : s.toCharArray()) {
            if (ch == last) {
                return false;
            }

            last = ch;
        }

        return true;
    }
}
