package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/21/20.
 */
public class BS238_Remove_Interval_Overlaps {

    public int solve(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int count = 0;
        int last = intervals[0][0] - 1;

        for (int[] interval : intervals) {
            if (interval[0] >= last) {
                count++;
                last = interval[1];
            }
        }

        return intervals.length - count;
    }
}
