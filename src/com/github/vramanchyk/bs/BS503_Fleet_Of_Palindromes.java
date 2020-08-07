package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS503_Fleet_Of_Palindromes {

    public boolean solve(String s, int k) {
        if (k > s.length()) {
            return false;
        }

        if (k == s.length()) {
            return true;
        }

        final int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        for (int index = 0; index < 26; index++) {
            if (count[index] % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
