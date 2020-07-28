package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class BS222_DoorRush {

    private int find(int max, int target, int[] values) {
        int l = 0, r = max - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (values[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public int solve(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        int max = 0;
        final int n = intervals.length;
        int[] values = new int[n];

        for (int[] value : intervals) {
            int pos = find(max, value[0], values);
            if (pos == max) {
                values[max++] = value[1];
            } else if (values[pos] > value[1]) {
                values[pos] = value[1];
            }
        }

        return max;
    }
}
