package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/5/20.
 */
public class BS290_Base_3_To_Integer {

    public int solve(String s) {
        int answer = 0;
        for (char ch : s.toCharArray()) {
            answer = answer * 3 + (ch - '0');
        }

        return answer;
    }
}
