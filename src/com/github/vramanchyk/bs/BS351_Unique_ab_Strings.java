package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS351_Unique_ab_Strings {

    public int solve(String s) {

        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                count++;
            }
        }

        return 1 << count;
    }
}
