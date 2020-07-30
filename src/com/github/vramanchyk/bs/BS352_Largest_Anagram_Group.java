package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitali Ramanchyk on 7/29/20.
 */
public class BS352_Largest_Anagram_Group {

    private String norm(String w) {
        char[] ch = w.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public int solve(String[] words) {
        Map<String, Integer> groups = new HashMap<>();

        int ans = 0;
        for (String w : words) {
            String norm = norm(w);
            int size = groups.getOrDefault(norm, 0) + 1;
            groups.put(norm, size);
            ans = Math.max(ans, size);
        }

        return ans;
    }
}
