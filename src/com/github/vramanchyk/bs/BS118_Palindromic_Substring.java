package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS118_Palindromic_Substring {

    private int length(int l, int r, String s) {
        int len = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            len += 2;
        }

        return len;
    }

    public int solve(String s) {
        int answer = 0;

        for (int index = 0; index < s.length(); index++) {
            answer = Math.max(answer, 1 + length(index - 1, index + 1, s));
            if (index > 0 && s.charAt(index - 1) == s.charAt(index)) {
                answer = Math.max(answer, 2 + length(index - 2, index + 1, s));
            }
        }

        return answer;
    }
}
