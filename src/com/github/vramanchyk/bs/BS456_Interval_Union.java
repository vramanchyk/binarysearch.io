package com.github.vramanchyk.bs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Vitali Ramanchyk on 7/14/20.
 */
public class BS456_Interval_Union {

    public int[][] solve(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        final Deque<int[]> stack = new LinkedList<>();
        for (int[] interval : intervals) {

            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                if (stack.peek()[1] < interval[0]) {
                    stack.push(interval);
                } else {
                    int[] val = stack.pop();
                    stack.push(new int[]{val[0], Math.max(val[1], interval[1])});
                }
            }
        }

        int offset = stack.size() - 1;
        final int[][] result = new int[stack.size()][2];

        while (!stack.isEmpty()) {
            result[offset--] = stack.pop();
        }

        return result;
    }
}
