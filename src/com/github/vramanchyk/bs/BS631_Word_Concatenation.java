package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Vitali Ramanchyk on 7/30/20.
 */
public class BS631_Word_Concatenation {

    private int match(int offset, String str, String[] w, int[] dp, int cnt) {

        if (offset == str.length()) {
            return 1;
        }

        if (dp[offset] != 0) {
            return dp[offset];
        }

        boolean match = false;
        for (int i = 0; i < cnt; i++) {
            if (w[i].length() > str.length() - offset) {
                break;
            }

            if (str.indexOf(w[i], offset) == offset) {
                if (match = (match(offset + w[i].length(), str, w, dp, cnt) == 1)) {
                    break;
                }
            }
        }

        return dp[offset] = match ? 1 : -1;
    }


    public int solve(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int answer = 0;
        for (int index = 0; index < words.length; index++) {
            final String w = words[index];

            if (match(0, w, words, new int[w.length()], index) == 1) {
                answer++;
            }
        }

        return answer;
    }
}
