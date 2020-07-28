package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS365_Longest_Interval {

    public int solve(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        int r = intervals[0][0] - 1, l = intervals[0][0];
        int longest = 0;

        for (int[] value : intervals) {
            if (value[0] > r) {
                longest = Math.max(longest, r - l + 1);

                l = value[0];
                r = value[1];
            } else {
                r = Math.max(r, value[1]);
            }
        }

        return Math.max(longest, r - l + 1);
    }
}
