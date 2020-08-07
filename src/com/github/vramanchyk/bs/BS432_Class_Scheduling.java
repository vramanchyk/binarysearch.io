package com.github.vramanchyk.bs;

import java.util.Arrays;

/**
 * Created by Vitali Ramanchyk on 8/7/20.
 */
public class BS432_Class_Scheduling {

    private int find(int max, int target, int[] values) {
        int l = 0, r = max - 1;

        while (l <= r) {
            final int m = (l + r) / 2;
            if (values[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public int solve(int[][] times) {
        Arrays.sort(times, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });


        int max = 0;
        final int n = times.length;
        final int[] values = new int[n];

        for (int[] time : times) {
            int len = find(max, time[0], values);
            if (len >= max) {
                values[max++] = time[1];
            } else if (time[1] < values[len]) {
                values[len] = time[1];
            }
        }

        return max;
    }
}
