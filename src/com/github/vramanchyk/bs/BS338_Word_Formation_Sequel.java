package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/23/20.
 */
public class BS338_Word_Formation_Sequel {

    private boolean match(String str, String pattern) {
        final int[] counts = new int[26];

        int stars = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == '*') {
                stars++;
            } else {
                counts[ch - 'a']++;
            }
        }

        for (char ch : str.toCharArray()) {
            if (--counts[ch - 'a'] < 0) {
                if (--stars < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int solve(String[] words, String letters) {
        int max = 0;
        for (String word : words) {
            if (match(word, letters)) {
                max = Math.max(max, word.length());
            }
        }

        return max;
    }
}
