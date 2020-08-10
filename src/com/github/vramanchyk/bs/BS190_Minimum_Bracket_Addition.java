package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/10/20.
 */
public class BS190_Minimum_Bracket_Addition {

    public int solve(String s) {
        int answer = 0;
        int openCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else {
                    answer++;
                }
            }
        }

        return answer + openCount;
    }
}
