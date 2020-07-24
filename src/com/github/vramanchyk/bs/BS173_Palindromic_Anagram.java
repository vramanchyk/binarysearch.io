package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS173_Palindromic_Anagram {

    public boolean solve(String s) {
        int[] count = new int[26];
        s.chars().forEach(ch -> count[ch - 'a']++);

        int oddCount = 0;
        for (int cnt : count) {
            if (cnt % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount < 2;
    }
}
