package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS400_K_Unique_Strings {

    public int solve(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int start = 0;
        while (start < 26 && freq[start] == 0) {
            start++;
        }

        int answer = 0;
        for (int index = start; index < 26 - k; index++) {
            answer += freq[index];
        }

        return answer;
    }
}
