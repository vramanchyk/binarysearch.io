package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS462_Anagram_Substrings {

    private boolean check(int[] a, int[] b) {
        for (int idx = 0; idx < a.length; idx++) {
            if (a[idx] != b[idx]) {
                return false;
            }
        }

        return true;
    }

    public int solve(String s0, String s1) {

        if (s1.length() < s0.length()) {
            return 0;
        }

        int[] target = new int[26];
        s0.chars().forEach(ch -> target[ch - 'a']++);

        int answer = 0;

        int[] current = new int[26];
        for (int index = 0; index < s0.length(); index++) {
            current[s1.charAt(index) - 'a']++;
        }

        if (check(target, current)) {
            answer++;
        }

        final int offset = s0.length();
        for (int index = offset; index < s1.length(); index++) {
            current[s1.charAt(index - offset) - 'a']--;
            current[s1.charAt(index) - 'a']++;

            if (check(target, current)) {
                answer++;
            }
        }

        return answer;
    }
}
