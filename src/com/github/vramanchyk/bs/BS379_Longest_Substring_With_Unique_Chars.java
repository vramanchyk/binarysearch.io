package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS379_Longest_Substring_With_Unique_Chars {

    public int solve(String s) {
        final int[] offset = new int[26];

        Arrays.fill(offset, -1);

        int result = 0;
        int left = 0;

        for (int index = 0; index < s.length(); index++) {
            int val = s.charAt(index) - 'a';

            if (offset[val] != -1) {
                left = Math.max(left, offset[val] + 1);
            }

            result = Math.max(result, index - left + 1);
            offset[val] = index;
        }

        return result;
    }
}
