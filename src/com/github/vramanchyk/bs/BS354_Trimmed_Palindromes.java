package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS354_Trimmed_Palindromes {

    private int count(int l, int r, String s) {
        int count = 1;

        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
            count++;
        }

        return count;
    }

    public int solve(String s) {

        int result = 0;
        for (int index = 0; index < s.length(); index++) {
            result += count(index - 1, index + 1, s);
            if (index > 0 && s.charAt(index) == s.charAt(index - 1)) {
                result += count(index - 2, index + 1, s);
            }
        }

        return result;
    }
}
