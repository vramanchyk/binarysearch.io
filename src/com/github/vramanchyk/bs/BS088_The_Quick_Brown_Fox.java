package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS088_The_Quick_Brown_Fox {

    private int[] prefix(String str) {
        final int n = str.length();
        final int[] prefix = new int[n];

        for (int i = 1; i < n; i++) {
            int j = prefix[i - 1];

            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = prefix[j - 1];
            }

            if (str.charAt(j) == str.charAt(i)) {
                j++;
            }

            prefix[i] = j;
        }

        return prefix;
    }

    private List<Integer> kmp(String text, String pattern) {
        final int[] prefix = prefix(pattern + "$" + text);

        final int offset = pattern.length() + 1;
        final List<Integer> result = new ArrayList<>();
        for (int index = 0; index < text.length(); index++) {
            if (prefix[index + offset] == offset - 1) {
                result.add(index - offset + 2);
            }
        }
        return result;
    }

    public boolean solve(String[] words, String s) {
        final Map<Integer, List<Integer>> jumps = new HashMap<>();

        for (String word : words) {
            for (Integer offset : kmp(s, word)) {
                jumps.computeIfAbsent(offset, v -> new ArrayList<>()).add(word.length());
            }
        }

        boolean[] visited = new boolean[s.length() + 1];
        visited[0] = true;

        for (int index = 0; index < s.length(); index++) {
            if (visited[index]) {
                List<Integer> offsets = jumps.get(index);
                if (offsets != null) {
                    for (int offset : offsets) {
                        visited[index + offset] = true;
                    }
                }
            }
        }

        return visited[s.length()];
    }
}
