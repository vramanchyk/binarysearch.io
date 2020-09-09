package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 9/8/20.
 */
public class BS714_Longest_Concatenated_String {

    public int solve(String[] words) {

        final int[][] counts = new int[26][26];

        for (final String word : words) {

            final int len = word.length();

            final int first = word.charAt(0) - 'a';
            final int last = word.charAt(len - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                if (counts[j][first] != 0) {
                    counts[j][last] = Math.max(counts[j][last], counts[j][first] + len);
                }
            }

            counts[first][last] = Math.max(counts[first][last], len);
        }

        int maxLen = 0;
        for (int i = 0; i < 26; i++) {
            maxLen = Math.max(maxLen, counts[i][i]);
        }

        return maxLen;
    }
}
