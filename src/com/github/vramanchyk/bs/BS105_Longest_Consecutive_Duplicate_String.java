package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS105_Longest_Consecutive_Duplicate_String {

    public int solve(String s) {

        char lastChar = 0;
        int currentLength = 0;

        int maxLength = 0;
        for (char ch : s.toCharArray()) {

            if (ch != lastChar) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }

            lastChar = ch;
            currentLength++;
        }

        return Math.max(maxLength, currentLength);
    }
}
