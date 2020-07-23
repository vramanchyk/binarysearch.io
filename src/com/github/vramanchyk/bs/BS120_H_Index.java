package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS120_H_Index {

    public int solve(int[] citations) {
        Arrays.sort(citations);

        final int len = citations.length;
        int l = 0, r = len - 1;

        int ans = len;

        while (l < r) {
            int m = (l + r) / 2;
            int count = len - m;
            if (citations[m] >= count) {
                r = m - 1;
                ans = count;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}
